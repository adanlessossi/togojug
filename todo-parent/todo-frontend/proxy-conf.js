module.exports = {
  "todo/api/*": {
    "target": "http://localhost:8085",
    "secure": false,
    "logLevel": "debug",
    "changeOrigin": true,
    "headers": {
      "Connection": "keep-alive"
    }
  }
}
