# requirements_management
## 部署方法：
1、在application.properties修改你需要的服务器端口和数据库配置
2、将db.sql导入你的数据库
3、在项目目录下运行mvn package生成jar包（默认保存在target文件夹下）
4、java -jar ***.jar(你的jar包名称)运行项目
