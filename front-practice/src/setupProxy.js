const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(
            '/api',
            createProxyMiddleware({
                target: 'http://localhost:8080',
            changeOrigin: true,
            }
        )
    );
};
//
// const {createProxyMiddleware} = require('http-proxy-middleware');
//
// // src/setupProxy.js
// module.exports = function(app) {
//     app.use(
//         '/login',
//         createProxyMiddleware({
//             target :"http://localhost:8080",
//             changeOrigin: true
//         })
//     );
// };
//
//
