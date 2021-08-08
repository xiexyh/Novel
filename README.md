# Novel
基于Struts2和Hibernate的小说网站<br>
小说网站项目说明<br>
1、导入数据库<br>
从压缩文件中导入novel.dmp<br>
命令：DOS窗口运行命令<br>
imp Oracle用户/密码 file=文件路径\novel.dmp tables=classification,chapters,identify,users,novel<br>
2、创建序列<br>
打开数据准备.txt,然后到oracle数据库中执行里边代码<br>
3、运行环境：jdk1.8,tomcat9.0，Spring-tool-suite4<br>
4、访问路径：http://localhost:8080/Novel/index<br>
5、系统管理员账号密码都是admin<br>
6、普通用户账号密码都是test<br>
7、实现功能：登录注册、小说首页、小说分类、分类详情、小说详情、章节详情（只有在已登录状态下才能看）、个人主页<br>
注：以下页面只有系统管理员登录才可访问<br>
管理员页面、管理分类页面、管理书籍页面、管理章节、管理用户、下载图片、修改页面
