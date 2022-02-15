大家好，我是银洋，今天和大家一起分享一下软件版本管理方面的一些实践。

主要内容包括Git、Github、GitLab、Gitee。

很多人包括我自己在最开始使用git的时候搞不太清除git、Github、GitLab、Gitee有什么区别和联系。

那么今天我就以尽量简单易懂的视角来和大家一起来了解一下这款必备工具。



当项目超过一定规模，需要团队合作的时候，版本管理软件就是必不可少的。

版本控制软件的发展历程从VSS、到Subversion（SVN)，到Git，



git可能有的人更加推荐命令行，这个也是一个仁者见仁的事情，我自己平时这两种模式都会用到，命令行更方便于写脚本、自动化、更加快捷。而图形化UI界面操作通常更加直观，更容易入门，而且当项目版本历史比较复杂并且存在多个分支合并操作时可以直观地看到这些分支的来龙去脉。

当然命令行和图形化的所有操作都是一致的，最重要的还是要掌握Git以及版本控制系统的核心理念。



介绍git：PDF

四个工作区域/三个工作区域

git的文件状态

分支

需要记住的命令



因为我们的开发环境不能够访问外网，而腾讯会议的时候又访问不到我们的开发环境，所以作为折中方案我这边录了一个在我们开发环境实际使用Git和Gitlab的视频，从git的下载安装、账户的创建、到远端GitLab上传、以及CI/CD的自动化编译部署等操作。视频也已经上传到我们科技部的经验知识库、GitLab、以及我们私有云上面，大家如果感兴趣的话可以下载下来和视频里面一样一步一步操作，如果有任何问题也可以随时飞秋或者微信我。那么下面我们就一起看一下这个视频的内容。

实际操作，录像（16.24.35.10）：

1. Git的安装

2. 用户配置

   ```bash
   git config --global user.name yinyang
   git config --global user.email yinyang@sjbank.com

   ssh-keygen
   ```



3. 创建仓库：接下来的第一步是创建一个仓库（Repository），“仓库” 这个术语指的是与项目相关的所有文件。包括源代码、工程文件、资源文件和一些配置信息。可以是本地的仓库，也可以是保存在远程服务器上的仓库。仓库之间可以相互同步。比如你可以把本地计算机上的代码同步到远程的服务器上，GitHub上就保存了很多远程代码仓库，它也是当今最大的代码托管网站和开源社区。与Github类似的还有GitLab、Gitee。这三家的功能基本相同，个人使用基本都是免费的。国内使用的话Gitee是速度最快的，Github和Gitlab由于服务器在国外速度方面会稍微慢一些。顺带提一下我们科技部内部建立了一个私有GitLab服务器，IP地址是16.24.35.10，是完全开放注册的，大家可以随意使用，目前已经有很多项目组在使用了，包括新老核心、开放平台、智能存款等等。下面我们就来分别演示从本地创建仓库和远程创建仓库的方法：

   ```bash
   # 本地创建仓库
   # git init 会生成一个.git文件夹，里面保存了这个仓库的所有信息，
   # git就是通过这个.git文件夹来识别当前目录是否是一个git 仓库的。我们可以把这个文件夹复制到一个未加入git管理的位置来使其加入到仓库中。
   git init

   # 远程创建仓库，界面上直接操作就可以
   git clone repo
   然后我们可以使用git clone来将远程仓库克隆到本地，我们同样也可以在项目的根目录下面看到这个.git文件夹。
   ```



4. 提交

   提交这个术语很像是游戏里面的检查点或者快照，当你觉得前面可能会挂掉的时候我们一般会先保存一下，编码的时候也是一样，一般完成了一个功能之后就可以commit一下。这样以后任何时候都可以回溯到这个时点的代码状态。

   这里呢我们创建一个非常简单的c程序 hello.c，保存之后我们使用git add 将它加入到暂存区。git要求在对修改的文件进行提交之前必须将它们Stage，也就是放到暂存区里面。（演示git add .前后状态的变化）

   **只有放在暂存区的文件才会被提交到仓库**，

   commit还有一个必须要填写的就是提交信息内容，如果你面对的是一大堆无名的历史提交，内心一定是崩溃的。（演示核心版本管理。）

5. 推送（Push）

   目前为止我们所有的操作都是针对本地代码仓库的，如果我们去浏览GitLab上的远程仓库，可以看到还是处于最原始的状态。如果我们希望将所有的提交都同步到远程的GitLab服务器上。让所有人都能够看到你的修改内容的话，需要使用到git的push命令，也叫做“推送”，git push 是`git push origin master`的缩写，Git默认使用`origin`作为远程服务器的名字，可以使用`git remote -v`命令来查看远程服务器的地址。也可以使用git remote rm 和git remote add来删除或者添加远程服务器。执行了`git push`之后，我们再次去刷新远程Gitlab服务器的内容就可以看到我们所有的代码都已经成功上传上去了。

   如果我们点击gitlab上的commit，也可以看到和本地一样的提交历史。

6. 下载（Pull）

   我们既然可以把本地提交推送到远端服务器，就一定也可以从远程服务器下载新的提交内容。接下来我们来看一下Git中与Push相对应的pull操作，“拉取”操作。这里比如我使用李鑫的账号对hello.c文件进行一点小修改。并推送到了Gitlab。可以从git log命令行，gitlab的commit按钮，或者图形化的界面上都看到提交历史，还可以直接看到提交的详细变化内容，这对于我们进行代码评审和review是非常方便的。



7. 合并（Merge）

   如果两个人同时修改了同一个源码文件会怎么样呢，接下来我们来看一下Git中的合并操作，也是版本控制中重要的一环。比如说lix在hello.c 中添加了一个函数，而我则修改了主函数的输出内容。如果我们希望将这两个对hello.c的修改同时应用在你本地的代码仓库中。我们就需要将这两个提交合并起来，合并在git中有很多种方式，我们这里只介绍两种最常用到的，一是直接使用之前提到的pull功能，Git会在获取远程提交的同时，将远程的提交合并在本地的提交中。git非常聪明，如果两个人没有修改同一行文件，那么基本上所有的提交内容会被自动合并merged。比如这里我们执行了git pull之后，可以看到lix的修改内容已经同步到了我的本地仓库中，这两处的修改已经被git自动合并了。

   这时候可能有人会问了，如果两个人修改了同一个文件的同一处位置，git又会怎么做呢，我们一起来研究一下，这次lix同学在前面加了一个“Little”，我们也去修改同一行代码，把这里的“git” 改成“开车了！”。然后本地提交这次修改。然后再次执行pull拉取远程的代码，不过这次Git的自动合并失败了。取而代之的呢是一个错误信息，告诉我们这里有冲突（Conflict)需要手动解决。原因很简单，git也不知道我们到底要如何合并了。毕竟我和李鑫可能都不知道到底要留下哪个版本。。

   这个时候就需要手工打开冲突的文件，找到冲突的位置来手工修改合并后的文件。修改完成之后呢，我们保存文件，然后commit提交一下，就可以解决冲突了。

8. 其他高级概念：
   * CI/CD，演示makefile自动编译：
     这里我们使用makefile来执行项目工程的编译，java项目可以使用maven或者bundle等其他命令代替。
     还是我们刚刚的helloworld项目，我们给项目添加一个makefile文件，使得项目代码发生变更时可以通过make命令来自动生成新的可执行文件，
     也就是我们通常所说的打版和发布工作，GitLab为我们提供了将这个工作自动化的支持，也就是在CI/CD这里，我们点击为项目添加CI/CD支持，
     然后就会在我们的项目仓库根目录下生成一个.gitlab-ci.yml文件。这里不同的平台处理是不同的，比如github就是生成一个.github目录。
     下面我们一起来看一下这个.gitlab-ci.yml文件，它使用YAML语法，第一部分中的stages表示了我们的工作分为几个阶段。模板中是三个阶段，
     分别是build（编译）、test（测试）、deploy（发布），这些步骤定义好之后通过gitlab-runner来执行。并将执行结果实时更新到Gitlab的页面上，
     这里以我们配置好的老核心项目为例演示一下，当我们修改了源码之后，执行git push操作，就会自动触发Gitlab的cicd操作，
     然后执行核心系统的编译脚本，然后自动执行一些静态代码检查工作，最后发布到某个测试环境上。
```yml
stages:          # List of stages for jobs, and their order of execution
  - build
  - test
  - deploy

build-job:       # This job runs in the build stage, which runs first.
  stage: build
  script:
    - echo "Compiling the code..."
    - echo "Compile complete."

unit-test-job:   # This job runs in the test stage.
  stage: test    # It only starts when the job in the build stage completes successfully.
  script:
    - echo "Running unit tests... This will take about 60 seconds."
    - sleep 60
    - echo "Code coverage is 90%"

lint-test-job:   # This job also runs in the test stage.
  stage: test    # It can run at the same time as unit-test-job (in parallel).
  script:
    - echo "Linting code... This will take about 10 seconds."
    - sleep 10
    - echo "No lint issues found."

deploy-job:      # This job runs in the deploy stage.
  stage: deploy  # It only runs when *both* jobs in the test stage complete successfully.
  script:
    - echo "Deploying application..."
    - echo "Application successfully deployed."

```
   * README.md

       项目的简介文件，使用markdown语法，GitLab、GitHub、Gitee均支持读取并解析这个文件并显示为Web页面。


   * issues：用来记录bug和问题，使用markdown语法。

   * wiki：项目相关的经验知识库，同样使用markdown语法。我们点击编辑后可以看到markdown语法非常的简单，但是生成的文档格式却非常生动，
          比如支持不同语言的语法高亮显示、支持图片的文件的上传下载、支持链接等等。比如我们可以截图后直接Ctrl+V自动粘贴图片、文档直接拖拽上传等。非常方便。
   * .gitignore
          一些不希望放到git仓库中进行管理的文件，可以放到这里，让git忽略它们。

1. 其他高级概念：

   * 分支（Branch）

   * 标签（Tag）

   * Pull Request

   * 权限管理

   * fetch、rebase


2.  对于Git的常用命令，我列了个表供大家参考。

   ```bash
   # 配置基本用户信息
   git config --global user.name <你的用户名>
   git config --global user.email <你的邮箱地址>

   # 创建一个新仓库
   git init

   # 从远程服务器克隆一个仓库
   git clone <远程仓库的URL>

   # 显示当前的工作目录下的提交文件状态
   git status

   # 加入暂存区
   git add <文件路径>

   # 取消暂存
   git reset <文件路径>

   # 提交
   git commit -m "提交信息"

   # 显示提交历史
   git log

   # 向远程仓库推送（Push）
   git push

   # 从远程仓库拉取（Pull）
   git pull

   # GitLab地址
   16.24.35.10

   # 私有云地址
   16.24.38.127

   ```







