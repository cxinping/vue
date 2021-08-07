前端运行

# 进入项目目录
cd ruoyi-ui

# 安装依赖
npm install

# 强烈建议不要用直接使用 cnpm 安装，会有各种诡异的 bug，可以通过重新指定 registry 来解决 npm 安装速度慢的问题。
npm install --registry=https://registry.npm.taobao.org

# 本地开发 启动项目
npm run dev

# 打包正式环境
npm run build:prod

在Windows平台下结束该进程
taskkill /f /t /im nginx.exe


4、打开浏览器，输入：http://localhost:8011 （默认账户 admin/admin123）

http://localhost:8011/

5. 修改xinping 账号密码
mysqladmin -uxinping -p123456 password 123welcome

6. 登录接口

http://localhost:8080/login
username=admin
password=admin123
code=2
uuid=6aeb55202133412381d9d30c701bb2ea

{
   "msg": "操作成功",
   "code": 200,
   "token": "eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImFlMzYxMjAzLTJlOWQtNDE0Yi04NWQzLTAyNmNjZGZiMjY3MSJ9.rod4cZpJGzN1dPfl_seI3P_cuaM71hOq_uDh3I30rcEJX6gWOL4nYPuv22Xhv5LdmovKyEMcUIifE_ZM_GRybw"
}

Authorization : eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImFlMzYxMjAzLTJlOWQtNDE0Yi04NWQzLTAyNmNjZGZiMjY3MSJ9.rod4cZpJGzN1dPfl_seI3P_cuaM71hOq_uDh3I30rcEJX6gWOL4nYPuv22Xhv5LdmovKyEMcUIifE_ZM_GRybw

http://www.ultrapower.com:8888/index

部署项目
nohup java -jar ruoyi-admin.jar &
nohup java -jar test-ruoyi-admin.jar &
nohup java -jar itranswarp.jar &

重启Nginx服务
/usr/local/nginx/sbin/nginx -s stop
/usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf


测试服务器 http://www.ultrapower.com:7777/
生产服务器 http://www.ultrapower.com:8888/

测试后端接口需要把 D:\quant\vue\Chapter01\RuoYi-Vue\ruoyi-admin\target\ruoyi-admin.jar 改为 test-ruoyi-admin.jar

http://www.ultrapower.com:8888
超级管理员可以创建账号
admin
admin123

员工账号，可以访问所有的输入页面，包括统计页面
用户名：gao
密码：123456

领导账号，只能访问统计页面
用户名：leader
密码：123456

Nginx部署

在Windows平台下结束该进程
taskkill /f /t /im nginx.exe

http://127.0.0.1:8888




select * from jalo_purchase_order_tracking_information;

select project_name, contract_signing_time,prepayment_payable_time from jalo_purchase_order_tracking_information;

update jalo_purchase_order_tracking_information set prepayment_payable_time=contract_signing_time ;




