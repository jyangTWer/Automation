Mac
1. 用brew安装ruby，ruby 2.7.1p83 (2020-03-31 revision a0c7c23c9c) [x86_64-darwin19]
2. 将安装好后的路径（/usr/local/Cellar/ruby/2.7.1_2/bin/）放到PATH之前，配置到.bash_profile或者.bashrc或者.zshrc里都可以。这个路径中包含ruby，gem和bundle
3. 配置需要安装的包在Gemfile中，执行```bundle install```，会生成Gemfile.lock文件，如果大家克隆了这个文件，安装的时候会按照.lock中的版本依赖进行安装，如果没有.lock，会安装最新的包依赖进行安装。
4. 执行```cucumber --init```，初始化出features目录，
