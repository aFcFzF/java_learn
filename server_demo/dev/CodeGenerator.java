
/**
 * @file CodeGenerator.java
 * @author afcfzf(9301462@qq.com)
 */

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

import static org.mockito.ArgumentMatchers.matches;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

public class CodeGenerator {
  public static <T extends String> Map<T, String> decodeEnc(T[] propKeys)
      throws FileNotFoundException, IOException, Exception {
    // 获取mysql地址
    String dirName = CodeGenerator.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    String secretPropFilePath = Paths.get(dirName, "secrets.properties").toString();
    String appPropFilePath = Paths.get(dirName, "application.properties").toString();

    Properties props = new Properties();
    // secret:
    FileReader reader = new FileReader(secretPropFilePath);
    props.load(reader);
    String pwd = props.getProperty("jasypt.encryptor.password");
    System.out.println("passwd: " + pwd);
    reader.close();

    // jsypt
    reader = new FileReader(appPropFilePath);
    props.load(reader);
    reader.close();

    String algorithm = props.getProperty("jasypt.encryptor.algorithm");
    String iv = props.getProperty("jasypt.encryptor.iv-generator-classname");

    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword(pwd);
    encryptor.setAlgorithm(algorithm);

    Map<T, String> result = new HashMap<>(propKeys.length);

    for (T propKey : propKeys) {
      String re = "^ENC\\((.+)\\)$";
      Matcher mat = Pattern.compile(re).matcher(props.getProperty(propKey));
      if (mat.find() && mat.groupCount() >= 1) {
        String decodeVal = encryptor.decrypt(mat.group(1));
        result.put(propKey, decodeVal);
        System.out.println("decode ==== " + decodeVal);
      } else {
        throw new Exception("Cannot decode key" + propKey);
      }
    }

    return result;
  }

  public static void main(String[] args) throws Exception {
    Map<String, String> decodeDict;
    String[] propKeys = { "spring.datasource.url", "spring.datasource.username", "spring.datasource.password" };
    decodeDict = CodeGenerator.decodeEnc(propKeys);
    System.out.println(decodeDict.entrySet());

    // 数据源配置
    FastAutoGenerator.create(decodeDict.get("spring.datasource.url"),
        decodeDict.get("spring.datasource.username"),
        decodeDict.get("spring.datasource.password"))
        .globalConfig(builder -> {
          builder.author("austin") // 设置作者
              .enableSwagger() // 开启 swagger 模式 默认值:false
              .disableOpenDir() // 禁止打开输出目录 默认值:true
              .commentDate("yyyy-MM-dd") // 注释日期
              .dateType(DateType.ONLY_DATE) // 定义生成的实体类中日期类型 DateType.ONLY_DATE 默认值:
              // DateType.TIME_PACK
              .outputDir(System.getProperty("user.dir") + "/src/main/java"); // 指定输出目录
        })

        .packageConfig(builder -> {
          builder.parent("com.shardingspherejdbc.mybatisplus") // 父包模块名
              .controller("controller") // Controller 包名 默认值:controller
              .entity("entity") // Entity 包名 默认值:entity
              .service("service") // Service 包名 默认值:service
              .mapper("mapper") // Mapper 包名 默认值:mapper
              // .other("model")
              // .moduleName("xxx") // 设置父包模块名 默认值:无
              .pathInfo(Collections.singletonMap(OutputFile.xml,
                  System.getProperty("user.dir") + "/src/main/resources/mapper")); //
          // 设置mapperXml生成路径
          // 默认存放在mapper的xml下
        })

        .injectionConfig(consumer -> {
          Map<String, String> customFile = new HashMap<>();
          // DTO、VO
          customFile.put("DTO.java", "/templates/entityDTO.java.ftl");
          customFile.put("VO.java", "/templates/entityVO.java.ftl");

          consumer.customFile(customFile);
        })

        .strategyConfig(builder -> {
          builder.addInclude("user") // 设置需要生成的表名 可边长参数“user”, “user1”
              .addTablePrefix("tb_", "gms_") // 设置过滤表前缀
              .serviceBuilder()// service策略配置
              .formatServiceFileName("%sService")
              .formatServiceImplFileName("%sServiceImpl")
              .entityBuilder()// 实体类策略配置
              .idType(IdType.ASSIGN_ID)// 主键策略 雪花算法自动生成的id
              .addTableFills(new Column("create_time", FieldFill.INSERT)) // 自动填充配置
              .addTableFills(new Property("update_time", FieldFill.INSERT_UPDATE))
              .enableLombok() // 开启lombok
              .logicDeleteColumnName("deleted")// 说明逻辑删除是哪个字段
              .enableTableFieldAnnotation()// 属性加上注解说明
              .controllerBuilder() // controller 策略配置
              .formatFileName("%sController")
              .enableRestStyle() // 开启RestController注解
              .mapperBuilder()// mapper策略配置
              .formatMapperFileName("%sMapper")
              .enableMapperAnnotation()// @mapper注解开启
              .formatXmlFileName("%sMapper");
        })
        .execute();
  }
}
