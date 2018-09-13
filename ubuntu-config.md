
## 配置国内源

1. 备份配置文件
```
sudo cp /etc/apt/source.list /etc/apt/source.list.bak

sudo vi /etc/apt/source.list
```
2. 粘贴以下阿里源

```
deb-src http://archive.ubuntu.com/ubuntu xenial main restricted #Added by software-properties
deb http://mirrors.aliyun.com/ubuntu/ xenial main restricted
deb-src http://mirrors.aliyun.com/ubuntu/ xenial main restricted multiverse universe #Added by software-properties
deb http://mirrors.aliyun.com/ubuntu/ xenial-updates main restricted
deb-src http://mirrors.aliyun.com/ubuntu/ xenial-updates main restricted multiverse universe #Added by software-properties
deb http://mirrors.aliyun.com/ubuntu/ xenial universe
deb http://mirrors.aliyun.com/ubuntu/ xenial-updates universe
deb http://mirrors.aliyun.com/ubuntu/ xenial multiverse
deb http://mirrors.aliyun.com/ubuntu/ xenial-updates multiverse
deb http://mirrors.aliyun.com/ubuntu/ xenial-backports main restricted universe multiverse
deb-src http://mirrors.aliyun.com/ubuntu/ xenial-backports main restricted universe multiverse #Added by software-properties
deb http://archive.canonical.com/ubuntu xenial partner
deb-src http://archive.canonical.com/ubuntu xenial partner
deb http://mirrors.aliyun.com/ubuntu/ xenial-security main restricted
deb-src http://mirrors.aliyun.com/ubuntu/ xenial-security main restricted multiverse universe #Added by software-properties
deb http://mirrors.aliyun.com/ubuntu/ xenial-security universe
deb http://mirrors.aliyun.com/ubuntu/ xenial-security multiverse
```
3. 更新
```
apt-get update
```

## ftp配置（用FXP传输文件用）

1. 安装vsftpd

```
sudo apt-get install vsftpd
```
2. 配置

```
sudo vi /etc/vsftpd.conf
```
加入可写权限
```
write_enable=YES
```

## nodejs配置

1. 下载安装包

> [nodejs中文网](http://nodejs.cn/)

下载 -> linux64位 -> xx.xx.xx.tar.xz

2. 下载导入到Ubuntu中
3. 解压安装
```
tar -xvf node.xx.xx.tar.xz
mv node.xx.xx nodejs
```
4. 将node和npm建立软连接，设为全局

> /home/zhangbaoqi/nodejs 是我的nodejs安装地址
```
sudo ln -s /home/zhangbaoqi/nodejs/bin/npm /usr/local/bin/ 
sudo ln -s /home/zhangbaoqi/nodejs/bin/node /usr/local/bin/ 
```

如果软连接设置错误了可以删除
```
cd /usr/local/bin/
rm -rf 模块名
```
5. 安装cnpm 
```
npm install -g cnpm --registry=https://registry.npm.taobao.org
```
6. 为cnpm建立软连接，设为全局

> /home/zhangbaoqi/nodejs 是我的nodejs安装地址

```
sudo ln -s /home/zhangbaoqi/nodejs/bin/cnpm /usr/local/bin/ 
```
7. 安装express
> 过程基本同cnpm

```
sudo cnpm install -g express --save
sudo cnpm install -g express-generator --save
```
8. 为express建立软连接，设为全局
```
sudo ln -s /home/zhangbaoqi/nodejs/bin/express /usr/local/bin/ 
```
9. 使用express初始化
```
express hello
cnpm install
开启服务
cd hello 
npm start

```
如果出现Cannot find module 'http-errors'错误
那就是忘记了初始化了
```
使用cnpm install进行初始化
```
10. 查看端口是否启动
```
netstat -ap|grep 3000
```


> [妈的感谢这位小哥，解决了我很多天的问题](https://www.cnblogs.com/liuqi/p/6483317.html)

## jdk安装及环境变量配置

1. 下载安装包
2. 导入
3. 解压安装

```
tar xvf jdk-8u181-linux-x64.tar.gz
```
我的位置:/home/zhangbaoqi/jdk1.8.0_181

4. 配置环境变量

```
sudo vi /etc/environment
```
在文尾加入
```
PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:$JAVA_HOME/bin"
export CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib
export JAVA_HOME=/home/zhangbaoqi/jdk1.8.0_181
```
重新加载一下环境
```
source /etc/environment
```
这时候可以输入java -version 查看版本了

还没完毕，只配置这些在重启之后就用不了了。
```
sudo vi /etc/profile
```
在文尾加入
```
export JAVA_HOME=/home/zhangbaoqi/jdk1.8.0_181
export JRE_HOME=$JAVA_HOME/jre
export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH
export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$PATH
```
加载环境
```
source /etc/profile
```
OK

## Tomcat配置

1. 下载导入
2. 解压
```
tar -zxvf apache-tomcat-8.5.33.tar.gz  
```
3. 配置java
编辑bin/startup.sh 在最后一行添加
```
export JAVA_HOME=/home/zhangbaoqi/jdk1.8.0_181
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:%{JAVA_HOME}/lib:%{JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH
```

## nginx配置

1. 安装openssl
```
sudo apt-get install openssl
```
2. 解压
```
tar zxvf nginx-1.11.10.tar.gz
```
3. 安装gcc
```
sudo apt-get install gcc
```
4. 安装pcre
```
sudo apt-get install libpcre3 libpcre3-dev
```
5. 安装zlib
```
sudo apt-get install zlib1g-dev
```
6. 安装make
```
sudo apt-get install make
```
7. 安装
```
./configure --prefix=自己的路径，配置信息、日志什么都会放到里边
make
make install
```
> 执行以上后就可以删除了nginx安装包了。

OK

## redis安装

1. 下载解压

```
tar xzf redis-4.0.11.tar.gz
```

2. make
```
cd redis-4.0.11/
make
```

3. cd /src
4. ./redis-server
5. ./redis-cli

## mysql安装

1. 安装
```
sudo apt-get install mysql-server
```

2. 安装后会自动开启服务
