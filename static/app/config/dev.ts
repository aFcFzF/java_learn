/**
 * @file dev.ts
 * @author afcfzf(9301462@qq.com)
 */

import { IProjectConfig } from '@tarojs/taro/types/compile';

export const devConfig: IProjectConfig = {
  env: {
    NODE_ENV: '"development"',
  },
  defineConstants: {
  },
  mini: {},
  h5: {},
};
