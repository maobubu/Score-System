<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>绩效信息添加</title>
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

<div style="position: relative;top: 10%;width: 80%;margin-left: 10%">
            <form action="evaluate2_add_do.html" method="post" id="addevaluate2" >
                <div class="form-group">
                    <label for="camOpeExperiment">camOpeExperiment</label>
                    <input type="text" class="form-control" name="camOpeExperiment" id="camOpeExperiment" value=${detail.camOpeExperiment}>
                </div>
                <div class="form-group">
                    <label for="offCamOpeExperiment">offCamOpeExperiment</label>
                    <input type="text" class="form-control" name="offCamOpeExperiment" id="offCamOpeExperiment"  value=${detail.offCamOpeExperiment}>
                </div>

                <div class="form-group">
                    <label for="teaEfficiency">teaEfficiency</label>
                    <input type="text" class="form-control" name="teaEfficiency" id="teaEfficiency" value=${detail.teaEfficiency}>
                </div>

                <div class="form-group">
                    <label for="expTeaProject">expTeaProject</label>
                    <input type="text" class="form-control" name="expTeaProject" id="expTeaProject" value=${detail.expTeaProject}>
                </div>

                <div class="form-group">
                    <label for="teaPaper">teaPaper</label>
                    <input type="text" class="form-control" name="teaPaper" id="teaPaper" value=${detail.teaPaper}>
                </div>

                <div class="form-group">
                    <label for="expTeaMaterials">expTeaMaterials</label>
                    <input type="text" class="form-control" name="expTeaMaterials" id="expTeaMaterials" value=${detail.expTeaMaterials}>
                </div>

                <div class="form-group">
                    <label for="stuAward">stuAward</label>
                    <input type="text" class="form-control" name="stuAward" id="stuAward" value=${detail.stuAward}>
                </div>

                <div class="form-group">
                    <label for="sciResProject">sciResProject</label>
                    <input type="text" class="form-control" name="sciResProject" id="sciResProject" value=${detail.sciResProject}>
                </div>
                <div class="form-group">
                    <label for="resPapers">resPapers</label>
                    <input type="text" class="form-control" name="resPapers" id="resPapers" value=${detail.resPapers}>
                </div>
                <div class="form-group">
                    <label for="socServices">socServices</label>
                    <input type="text" class="form-control" name="socServices" id="socServices" value=${detail.socServices}>
                </div>
                <div class="form-group">
                    <label for="updOfEquipment">updOfEquipment</label>
                    <input type="text" class="form-control" name="updOfEquipment" id="updOfEquipment" value=${detail.updOfEquipment}>
                </div>
                <div class="form-group">
                    <label for="valEquipment">valEquipment</label>
                    <input type="text" class="form-control" name="valEquipment" id="valEquipment" value=${detail.valEquipment}>
                </div>
                <div class="form-group">
                    <label for="stuAveArea">stuAveArea</label>
                    <input type="text" class="form-control" name="stuAveArea" id="stuAveArea" value=${detail.stuAveArea}>
                </div>
                <div class="form-group">
                    <label for="stuAveFund">stuAveFund</label>
                    <input type="text" class="form-control" name="stuAveFund" id="stuAveFund" value=${detail.stuAveFund}>
                </div>
                <div class="form-group">
                    <label for="stuAveTeaExpMatFund">stuAveTeaExpMatFund</label>
                    <input type="text" class="form-control" name="stuAveTeaExpMatFund" id="stuAveTeaExpMatFund" value=${detail.stuAveTeaExpMatFund}>
                </div>

                <div class="form-group">
                    <label for="perStructure">perStructure</label>
                    <input type="text" class="form-control" name="perStructure" id="perStructure" value=${detail.perStructure}>
                </div>
                <div class="form-group">
                    <label for="proAchievements">proAchievements</label>
                    <input type="text" class="form-control" name="proAchievements" id="proAchievements" value=${detail.proAchievements}>
                </div>


                <input type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
                <script>

                    function mySubmit(flag){
                        return flag;
                    }
                    $("#addevaluate2").submit(function () {
                        if($("#name").val()=''||$("#departmentID").val()==''){
                            alert("请填入完整绩效信息！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>

</div>



</body>
</html>
