import { PropsWithChildren, ReactNode, useEffect } from 'react';
import { useDidShow, useDidHide } from '@tarojs/taro';
// 全局样式
import './app.less';

const App = (props: PropsWithChildren): ReactNode => {
  // 可以使用所有的 React Hooks
  useEffect(() => {});

  // 对应 onShow
  useDidShow(() => {});

  // 对应 onHide
  useDidHide(() => {});

  return props.children;
};

export default App;

