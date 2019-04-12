<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实验室情况详情</title>
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
            <table class="table table-hover">

                <tr>
                    <th width="15%">id</th>
                    <td>${detail.id}</td>
                </tr>
                <tr>
                    <th>term_year</th>
                    <td>${detail.term_year}</td>
                </tr>
                <tr>
                    <th>lab_id</th>
                    <td>${detail.lab_id}</td>
                </tr>
                <tr>
                    <th>teacher_award_nation</th>
                    <td>${detail.teacher_award_nation}</td>
                </tr>
                <tr>
                    <th>teacher_award_patent</th>
                    <td>${detail.teacher_award_patent}</td>
                </tr>
                <tr>
                    <th>student_award</th>
                    <td>${detail.student_award}</td>
                </tr>
                <tr>
                    <th>teaching_paper_3retrieval</th>
                    <td>${detail.teaching_paper_3retrieval}</td>
                </tr>
                <tr>
                    <th>scientific_research_paper_3retrieval</th>
                    <td>${detail.scientific_research_paper_3retrieval}</td>
                </tr>
                <tr>
                    <th>teaching_paper_core_journal</th>
                    <td>${detail.teaching_paper_core_journal}</td>
                </tr>
                <tr>
                    <th>scientific_research_project_provincial</th>
                    <td>${detail.scientific_research_project_provincial}</td>
                </tr>
                <tr>
                    <th>scientific_research_project_other</th>
                    <td>${detail.scientific_research_project_other}</td>
                </tr>
                <tr>
                    <th>social_service_num</th>
                    <td>${detail.social_service_num}</td>
                </tr>
                <tr>
                    <th>research_project_provincial</th>
                    <td>${detail.research_project_provincial}</td>
                </tr>
                <tr>
                    <th>research_project_other</th>
                    <td>${detail.research_project_other}</td>
                </tr>
                <tr>
                    <th>open_experient_number_campus</th>
                    <td>${detail.open_experient_number_campus}</td>
                </tr>
                <tr>
                    <th>open_experient_number_Outcampus</th>
                    <td>${detail.open_experient_number_Outcampus}</td>
                </tr>
                <tr>
                    <th>open_experient_hour_campus</th>
                    <td>${detail.open_experient_hour_campus}</td>
                </tr>
                <tr>
                    <th>open_experient_hour_Outcampus</th>
                    <td>${detail.open_experient_hour_Outcampus}</td>
                </tr>
                <tr>
                    <th>using_area</th>
                    <td>${detail.using_area}</td>
                </tr>
                <tr>
                    <th>teaching_utilization</th>
                    <td>${detail.teaching_utilization}</td>
                </tr>
                <tr>
                    <th>teaching_experiment_project</th>
                    <td>${detail.teaching_experiment_project}</td>
                </tr>
                <tr>
                    <th>new_equipment</th>
                    <td>${detail.new_equipment}</td>
                </tr>
                <tr>
                    <th>val_equipment</th>
                    <td>${detail.val_equipment}</td>
                </tr>
                <tr>
                    <th>personal_structure</th>
                    <td>${detail.personal_structure}</td>
                </tr>
                <tr>
                    <th>award_fullTime</th>
                    <td>${detail.award_fullTime}</td>
                </tr>
                <tr>
                    <th>rate_partTime</th>
                    <td>${detail.rate_partTime}</td>
                </tr>
                <tr>
                    <th>exper_teaching_found</th>
                    <td>${detail.exper_teaching_found}</td>
                </tr>

                <tr>
                    <th>teaching_exper_found</th>
                    <td>${detail.teaching_exper_found}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
