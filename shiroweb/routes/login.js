var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/login.html', function(req, res, next) {
  res.render('authc/login', { title: '用户登录' });
});


module.exports = router;