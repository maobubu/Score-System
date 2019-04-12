<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实验室分数详情</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <style>
        body{
            background-color: rgb(240,242,245);
        }
    </style>

</head>
<!-- <body background="img/281289-106.jpg"> -->
<body>

<nav  style="position:fixed;z-index: 999;width: 100%;background-color: #fff" class="navbar navbar-default" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand" href="admin_main.html">实验室绩效管理系统</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        实验室管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="alllabs.html">全部实验室</a></li>
                        <li class="divider"></li>
                        <li><a href="labs_add.html">增加实验室</a></li>
                        <li class="divider"></li>
                        <li><a href="alldepartments.html">全部系别</a></li>
                        <li class="divider"></li>
                        <li><a href="departments_add.html">增加系别</a></li>
                        <li class="divider"></li>
                        <li><a href="allsysqks.html">全部实验室情况</a></li>
                        <li class="divider"></li>
                        <li><a href="sysqks_add.html">增加实验室情况</a></li>

                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        用户管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="allreaders.html">全部用户</a></li>
                        <li class="divider"></li>
                        <li><a href="reader_add.html">增加用户</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        绩点管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="allevaluate2s.html">全部绩点方案</a></li>
                        <li class="divider"></li>
                        <li><a href="evaluate2_add.html">增加绩点方案</a></li>
                    </ul>
                </li>
                <li >
                    <a href="admin_repasswd.html" >
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.html"><span class="glyphicon glyphicon-user"></span>&nbsp;${admin.adminId}，已登录</a></li>
                <li><a href="logout.html"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 10%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">《成绩编号 ${detail.id}》</h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">

                <tr>
                    <th width="15%">id</th>
                    <td>${detail.id}</td>
                </tr>
                <tr>
                    <th>实验室编号</th>
                    <td>${detail.lab_id}</td>
                </tr>
                <tr>
                    <th>学年</th>
                    <td>${detail.term_year}</td>
                </tr>

                <tr>
                    <th>camOpeExperiment</th>
                    <td>${detail.camOpeExperiment}</td>
                </tr>
                <tr>
                    <th>offCamOpeExperiment</th>
                    <td>${detail.offCamOpeExperiment}</td>
                </tr>
                <tr>
                    <th>teaEfficiency</th>
                    <td>${detail.teaEfficiency}</td>
                </tr>
                <tr>
                    <th>expTeaProject</th>
                    <td>${detail.expTeaProject}</td>
                </tr>
                <tr>
                    <th>teaPaper</th>
                    <td>${detail.teaPaper}</td>
                </tr>
                <tr>
                    <th>expTeaMaterials</th>
                    <td>${detail.expTeaMaterials}</td>
                </tr>
                <tr>
                    <th>stuAward</th>
                    <td>${detail.stuAward}</td>
                </tr>
                <tr>
                    <th>sciResProject</th>
                    <td>${detail.sciResProject}</td>
                </tr>
                <tr>
                    <th>resPapers</th>
                    <td>${detail.resPapers}</td>
                </tr>

                <tr>
                    <th>updOfEquipment</th>
                    <td>${detail.updOfEquipment}</td>
                </tr>
                <tr>
                    <th>valEquipment</th>
                    <td>${detail.valEquipment}</td>
                </tr>
                <tr>
                    <th>stuAveArea</th>
                    <td>${detail.stuAveArea}</td>
                </tr>
                <tr>
                    <th>stuAveFund</th>
                    <td>${detail.stuAveFund}</td>
                </tr>
                <tr>
                    <th>stuAveTeaExpMatFund</th>
                    <td>${detail.stuAveTeaExpMatFund}</td>
                </tr>
                <tr>
                    <th>perStructure</th>
                    <td>${detail.perStructure}</td>
                </tr>
                <tr>
                    <th>numOfParWorkers</th>
                    <td>${detail.numOfParWorkers}</td>
                </tr>
                <tr>
                    <th>proAchievements</th>
                    <td>${detail.proAchievements}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
