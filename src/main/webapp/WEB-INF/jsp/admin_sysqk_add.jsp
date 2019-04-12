<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实验室情况添加</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <style>
        body{
            background-color: rgb(240,242,245);
        }
    </style>

</head>

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
            <form action="sysqks_add_do.html" method="post" id="addsysqk" >
                <div class="form-group">
                    <label for="name">term_year</label>
                    <input type="text" class="form-control" name="term_year" id="term_year" placeholder="1990-2003">
                </div>
                <div class="form-group">
                    <label for="departmentID">lab_id</label>
                    <input type="text" class="form-control" name="lab_id" id="lab_id"  placeholder="请输入整数">
                    <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>
                </div>

                <div class="form-group">
                    <label for="name">teacher_award_nation</label>
                    <input type="text" class="form-control" name="teacher_award_nation" id="teacher_award_nation" placeholder="请输入小数">
                </div>

                <div class="form-group">
                    <label for="name">teacher_award_provincial</label>
                    <input type="text" class="form-control" name="teacher_award_provincial" id="teacher_award_provincial" placeholder="请输入小数">
                </div>

                <div class="form-group">
                    <label for="name">teacher_award_patent</label>
                    <input type="text" class="form-control" name="teacher_award_patent" id="teacher_award_patent" placeholder="请输入小数">
                </div>

                <div class="form-group">
                    <label for="name">student_award</label>
                    <input type="text" class="form-control" name="student_award" id="student_award" placeholder="请输入小数">
                </div>

                <div class="form-group">
                    <label for="name">teaching_paper_3retrieval</label>
                    <input type="text" class="form-control" name="teaching_paper_3retrieval" id="teaching_paper_3retrieval" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">scientific_research_paper_3retrieval</label>
                    <input type="text" class="form-control" name="scientific_research_paper_3retrieval" id="scientific_research_paper_3retrieval" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">teaching_paper_core_journal</label>
                    <input type="text" class="form-control" name="teaching_paper_core_journal" id="teaching_paper_core_journal" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">scientific_research_paper_core_journal</label>
                    <input type="text" class="form-control" name="scientific_research_paper_core_journal" id="scientific_research_paper_core_journal" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">paper_textbook</label>
                    <input type="text" class="form-control" name="paper_textbook" id="paper_textbook" placeholder="请输入整数">
                </div>
                <div class="form-group">
                    <label for="name">scientific_research_project_provincial</label>
                    <input type="text" class="form-control" name="scientific_research_project_provincial" id="scientific_research_project_provincial" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">scientific_research_project_other</label>
                    <input type="text" class="form-control" name="scientific_research_project_other" id="scientific_research_project_other" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">social_service_num</label>
                    <input type="text" class="form-control" name="social_service_num" id="social_service_num" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">research_project_provincial</label>
                    <input type="text" class="form-control" name="research_project_provincial" id="research_project_provincial" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">research_project_other</label>
                    <input type="text" class="form-control" name="research_project_other" id="research_project_other" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">open_experient_number_campus</label>
                    <input type="text" class="form-control" name="open_experient_number_campus" id="open_experient_number_campus" placeholder="请输入整数">
                </div>
                <div class="form-group">
                    <label for="name">open_experient_number_Outcampus</label>
                    <input type="text" class="form-control" name="open_experient_number_Outcampus" id="open_experient_number_Outcampus" placeholder="请输入整数">
                </div>
                <div class="form-group">
                    <label for="name">open_experient_hour_campus</label>
                    <input type="text" class="form-control" name="open_experient_hour_campus" id="open_experient_hour_campus" placeholder="请输入整数">
                </div>
                <div class="form-group">
                    <label for="name">open_experient_hour_Outcampus</label>
                    <input type="text" class="form-control" name="open_experient_hour_Outcampus" id="open_experient_hour_Outcampus" placeholder="请输入整数">
                </div>
                <div class="form-group">
                    <label for="name">using_area</label>
                    <input type="text" class="form-control" name="using_area" id="using_area" placeholder="请输入字符">
                </div>

                <div class="form-group">
                    <label for="name">teaching_utilization</label>
                    <input type="text" class="form-control" name="teaching_utilization" id="teaching_utilization" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">teaching_experiment_project</label>
                    <input type="text" class="form-control" name="teaching_experiment_project" id="teaching_experiment_project" placeholder="请输入字符">
                </div>
                <div class="form-group">
                    <label for="name">new_equipment</label>
                    <input type="text" class="form-control" name="new_equipment" id="new_equipment" placeholder="请输入字符">
                </div>
                <div class="form-group">
                    <label for="name">val_equipment</label>
                    <input type="text" class="form-control" name="val_equipment" id="val_equipment" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">personal_structure</label>
                    <input type="text" class="form-control" name="personal_structure" id="personal_structure" placeholder="请输入字符">
                </div>
                <div class="form-group">
                    <label for="name">award_fullTime</label>
                    <input type="text" class="form-control" name="award_fullTime" id="award_fullTime" placeholder="请输入整数">
                </div>
                <div class="form-group">
                    <label for="name">rate_partTime</label>
                    <input type="text" class="form-control" name="rate_partTime" id="rate_partTime" placeholder="请输入小数">
                </div>
                <div class="form-group">
                    <label for="name">exper_teaching_found</label>
                    <input type="text" class="form-control" name="exper_teaching_found" id="exper_teaching_found" placeholder="请输入非零小数">
                </div>
                <div class="form-group">
                    <label for="name">teaching_exper_found</label>
                    <input type="text" class="form-control" name="teaching_exper_found" id="teaching_exper_found" placeholder="请输入非零小数">
                </div>


                <input type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
                <script>

                    function mySubmit(flag){
                        return flag;
                    }
                    $("#addsysqk").submit(function () {
                        if($("#name").val()==""||$("#departmentID").val()==""||$("#open_experient_number_campus").val()==0||$("#teaching_exper_found").val()==0||$("#exper_teaching_found").val()==0){
                        alert("open_experient_number_campu, teaching_exper_found, exper_teaching_found 不能为0");
                        return mySubmit(false);
                        }
                    })
                </script>
            </form>

</div>



</body>
</html>
