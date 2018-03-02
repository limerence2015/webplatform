###需求描述
做一个系统的登录模块

####用户使用流程
1 用户通过数据地址访问系统，http://127.0.0.1:8000/bbs
2 如果地址输入正确，那么进入登录页面
3 登录页面包括的输入是：用户名、密码、登录按钮
4 用户自然会输入登录名、密码、然后会点击登录按钮
5 如果用户名密码对正确，那么就跳转到欢迎页面，如果不对就显示用户名密码错误
6 欢迎页面的信息包括：用户名，欢迎语，上次登录时间，退出按钮

####补充需求
1 用户的登录历史需要记录以便分析
2 登录的历史日志信息包括userId，loginLogDate，ip

####变量字段提取
username password lastLoginDate

####实体字段信息提取
1 User：username, password, userId, lastLoginDate, lastLoginIp, credit(积分)
2 LoginLog: login_log_id, userId, ip, loginDate

####技术设计流程
1 用户输入系统地址，通过web.xml的welcome-file-list配置进入登录页面
2 登录页面由login.jsp提供
3 login.jsp中的页面元素包括：用户名(文本框)、密码(密码框)、登录按钮(链接按钮)
4 用户点击登录按钮触发请求，http://127.0.0.1:8000/bbs/login
5 springMVC拦截到这个请求，指派给UserLoginService中login()方法
6 




