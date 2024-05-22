/*
 * @file tailwind.config.js
 * @author markJia(markjia@tencent.com)
 */

const generatePxScale = (): Record<string, string> => {
  const scale: Record<string, string> = {};
  for (let i = 0; i <= 1024; i += 1) {
    scale[i] = `${i}px`;
  }
  return scale;
};

export default {
  content: ['./build/template.html', './src/**/*.{js,ts,jsx,tsx}'],
  corePlugins: {
    preflight: false,
  },
  theme: {
    extend: {
      spacing: generatePxScale(),
      height: generatePxScale(),
      width: generatePxScale(),
      lineHeight: generatePxScale(),
      fontSize: {
        sm: '12px',
        base: '14px',
        normal: '16px',
        lg: '17px',
        xl: '20px',
        '1xl': '22px',
        '2xl': '24px',
      },
      borderRadius: {
        '2xl': '12px',
        '1xl': '10px',
        xl: '8px',
        lg: '6px',
        sm: '4px',
        xs: '3px',
      },
      colors: {
        blue: {
          500: '#296BEF',
          700: '#D4E1FC',
          800: '#EBF1FF',
        },
        gray: {
          // 按照od设计规范，由深到浅色
          100: '#0D0D0D',
          150: '#313233',
          200: '#464749',
          300: 'rgba(62, 69, 82, 0.36)',
          900: 'rgba(73, 90, 122, 0.1)',
        },
        green: {
          500: '#07C160',
        },
        red: {
          500: 'rgba(255, 97, 70, 1)',
          600: 'rgba(250, 81, 81, 1)',
          700: 'rgba(255, 97, 70, 0.15)',
          800: 'rgba(255, 97, 70, 0.03)',
        },
        orange: {
          100: 'rgba(255, 97, 70)',
        },
        link: 'rgba(87, 107, 149, 1)',
        'link-disabled': '#CDD3DF',
        black: 'rgba(0, 0, 0, 0.9)',
        white: '#fff',
      },
      borderWidth: {
        0.5: '0.5px',
        ...generatePxScale(),
      },
    },
  },
  plugins: [],
};
