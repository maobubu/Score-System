<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑《 ${detail.id}》</title>
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

<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 10%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">《实验室编号 ${detail.id}》</h3>
        </div>
        <div class="panel-body">
            <form action="sysqk_edit_do.html?id=${detail.id}" method="post" id="editsysqk" >

                <div class="input-group">
                    <span class="input-group-addon">term_year</span>
                    <input type="text" class="form-control" name="term_year" id="term_year" value=${detail.term_year}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">lab_id</span>
                    <input type="text" class="form-control" name="lab_id" id="lab_id"  value=${detail.lab_id}>
                    <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>
                </div>

                <div class="input-group">
                    <span class="input-group-addon">teacher_award_nation</span>
                    <input type="text" class="form-control" name="teacher_award_nation" id="teacher_award_nation" value=${detail.teacher_award_nation}>
                </div>

                <div class="input-group">
                    <span class="input-group-addon">teacher_award_provincial</span>
                    <input type="text" class="form-control" name="teacher_award_provincial" id="teacher_award_provincial" value=${detail.teacher_award_provincial}>
                </div>

                <div class="input-group">
                    <span class="input-group-addon">teacher_award_patent</span>
                    <input type="text" class="form-control" name="teacher_award_patent" id="teacher_award_patent" value=${detail.teacher_award_patent}>
                </div>

                <div class="input-group">
                    <span class="input-group-addon">student_award</span>
                    <input type="text" class="form-control" name="student_award" id="student_award" value=${detail.student_award}>
                </div>

                <div class="input-group">
                    <span class="input-group-addon">teaching_paper_3retrieval</span>
                    <input type="text" class="form-control" name="teaching_paper_3retrieval" id="teaching_paper_3retrieval" value=${detail.teaching_paper_3retrieval}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">scientific_research_paper_3retrieval</span>
                    <input type="text" class="form-control" name="scientific_research_paper_3retrieval" id="scientific_research_paper_3retrieval" value=${detail.scientific_research_paper_3retrieval}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">teaching_paper_core_journal</span>
                    <input type="text" class="form-control" name="teaching_paper_core_journal" id="teaching_paper_core_journal" value=${detail.teaching_paper_core_journal}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">scientific_research_paper_core_journal</span>
                    <input type="text" class="form-control" name="scientific_research_paper_core_journal" id="scientific_research_paper_core_journal" value=${detail.scientific_research_paper_core_journal}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">paper_textbook</span>
                    <input type="text" class="form-control" name="paper_textbook" id="paper_textbook" value=${detail.paper_textbook}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">scientific_research_project_provincial</span>
                    <input type="text" class="form-control" name="scientific_research_project_provincial" id="scientific_research_project_provincial" value=${detail.scientific_research_project_provincial}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">scientific_research_project_other</span>
                    <input type="text" class="form-control" name="scientific_research_project_other" id="scientific_research_project_other" value=${detail.scientific_research_project_other}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">social_service_num</span>
                    <input type="text" class="form-control" name="social_service_num" id="social_service_num" value=${detail.social_service_num}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">research_project_provincial</span>
                    <input type="text" class="form-control" name="research_project_provincial" id="research_project_provincial" value=${detail.research_project_provincial}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">research_project_other</span>
                    <input type="text" class="form-control" name="research_project_other" id="research_project_other" value=${detail.research_project_other}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">open_experient_number_campus</span>
                    <input type="text" class="form-control" name="open_experient_number_campus" id="open_experient_number_campus" value=${detail.open_experient_number_campus}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">open_experient_number_Outcampus</span>
                    <input type="text" class="form-control" name="open_experient_number_Outcampus" id="open_experient_number_Outcampus" value=${detail.open_experient_number_Outcampus}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">open_experient_hour_campus</span>
                    <input type="text" class="form-control" name="open_experient_hour_campus" id="open_experient_hour_campus" value=${detail.open_experient_hour_campus}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">open_experient_hour_Outcampus</span>
                    <input type="text" class="form-control" name="open_experient_hour_Outcampus" id="open_experient_hour_Outcampus" value=${detail.open_experient_hour_Outcampus}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">using_area</span>
                    <input type="text" class="form-control" name="using_area" id="using_area" value=${detail.using_area}>
                </div>

                <div class="input-group">
                    <span class="input-group-addon">teaching_utilization</span>
                    <input type="text" class="form-control" name="teaching_utilization" id="teaching_utilization" value= ${detail.teaching_utilization}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">teaching_experiment_project</span>
                    <input type="text" class="form-control" name="teaching_experiment_project" id="teaching_experiment_project" value=${detail.teaching_experiment_project}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">new_equipment</span>
                    <input type="text" class="form-control" name="new_equipment" id="new_equipment" value=${detail.new_equipment}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">val_equipment</span>
                    <input type="text" class="form-control" name="val_equipment" id="val_equipment" value=${detail.val_equipment}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">personal_structure</span>
                    <input type="text" class="form-control" name="personal_structure" id="personal_structure" value=${detail.personal_structure}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">award_fullTime</span>
                    <input type="text" class="form-control" name="award_fullTime" id="award_fullTime" value=${detail.award_fullTime}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">rate_partTime</span>
                    <input type="text" class="form-control" name="rate_partTime" id="rate_partTime" value=${detail.rate_partTime}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">exper_teaching_found</span>
                    <input type="text" class="form-control" name="exper_teaching_found" id="exper_teaching_found" value=${detail.exper_teaching_found}>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">teaching_exper_found</span>
                    <input type="text" class="form-control" name="teaching_exper_found" id="teaching_exper_found" value=${detail.teaching_exper_found}>
                </div>
                <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#editsysqk").submit(function () {
                        if($("#name").val()==""||$("#departmentID").val()==""||$("#open_experient_number_campus").val()==0||$("#teaching_exper_found").val()==0||$("#exper_teaching_found").val()==0){
                            alert("open_experient_number_campu, teaching_exper_found, exper_teaching_found 不能为0");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>
        </div>
    </div>

</div>

</body>
</html>
