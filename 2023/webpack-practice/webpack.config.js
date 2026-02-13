// export, import 처리 가능

// import
const path = require('path');
const HtmlPlugin = require('html-webpack-plugin');
const CopyPlugin = require('copy-webpack-plugin');

// export 
module.exports = {
  // 파일을 읽어들이기 시작하는 진입점 설정
  entry: './js/main.js',

  // (결과물을)반환하는 설정
  output: {
    // path: path.resolve(__dirname, 'public'),
    // filename: './main.js',
    clean: true
  }, 

  module: {
    rules: [
      {
        // [정규식] ? : 없거나 1개 이상
        test: /\.s?css$/,    //정규식 기재 
        use: [ 
              //순서 중요
              "style-loader",
              "css-loader",
              'postcss-loader', //npm i -d postcss autoprefixer postcss-loader 후, 적어주기 | postcss-loader => 공급업체에 접두어를 붙여준다.
              "sass-loader",
             ]
      },
      {
        test: /\.js$/,  
        use: [ 
              'babel-loader',
             ]
      },
    ]
  },

  // 번들링 후 결과물의 처리 방식 등 다양한 plugin을 설정
  plugins: [
    new HtmlPlugin({
      template: './index.html'
    }),
    new CopyPlugin({
      patterns: [{ from: 'static'}]
    }),
  ],

  devServer: {
    host: 'localhost'
  }
};
