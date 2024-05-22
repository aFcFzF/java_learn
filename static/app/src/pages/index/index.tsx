import { ScrollView } from '@tarojs/components';
import { Button } from '@nutui/nutui-react-taro';
import './index.less';
import { useEffect } from 'react';

export const Index = (): JSX.Element => {
  useEffect(() => {

  }, []);
  return (
    <ScrollView>
      <Button>测试</Button>
    </ScrollView>
  );
};

export default Index;
