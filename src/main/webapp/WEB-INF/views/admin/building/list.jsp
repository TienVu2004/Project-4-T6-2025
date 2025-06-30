<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/27/2025
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Danh sách toà nhà</title>
</head>
<body>
        <div class="main-content" style="font-family: 'Times New Roman', Times, serif;">
            <div class="main-content-inner">
                <div class="breadcrumbs" id="breadcrumbs">
                    <script type="text/javascript">
                        try {
                            ace.settings.check("breadcrumbs", "fixed");
                        } catch (e) {
                        }
                    </script>

                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#">Home</a>
                        </li>
                        <li class="active">Dashboard</li>
                    </ul>
                    <!-- /.breadcrumb -->
                </div>

                <div class="page-content">
                    <div class="ace-settings-container" id="ace-settings-container">
                        <div
                                class="btn btn-app btn-xs btn-warning ace-settings-btn"
                                id="ace-settings-btn"
                        >
                            <i class="ace-icon fa fa-cog bigger-130"></i>
                        </div>

                        <div class="ace-settings-box clearfix" id="ace-settings-box">
                            <div class="pull-left width-50">
                                <div class="ace-settings-item">
                                    <div class="pull-left">
                                        <select id="skin-colorpicker" class="hide">
                                            <option data-skin="no-skin" value="#438EB9">
                                                #438EB9
                                            </option>
                                            <option data-skin="skin-1" value="#222A2D">
                                                #222A2D
                                            </option>
                                            <option data-skin="skin-2" value="#C6487E">
                                                #C6487E
                                            </option>
                                            <option data-skin="skin-3" value="#D0D0D0">
                                                #D0D0D0
                                            </option>
                                        </select>
                                    </div>
                                    <span>&nbsp; Choose Skin</span>
                                </div>

                                <div class="ace-settings-item">
                                    <input
                                            type="checkbox"
                                            class="ace ace-checkbox-2"
                                            id="ace-settings-navbar"
                                    />
                                    <label class="lbl" for="ace-settings-navbar">
                                        Fixed Navbar</label
                                    >
                                </div>

                                <div class="ace-settings-item">
                                    <input
                                            type="checkbox"
                                            class="ace ace-checkbox-2"
                                            id="ace-settings-sidebar"
                                    />
                                    <label class="lbl" for="ace-settings-sidebar">
                                        Fixed Sidebar</label
                                    >
                                </div>

                                <div class="ace-settings-item">
                                    <input
                                            type="checkbox"
                                            class="ace ace-checkbox-2"
                                            id="ace-settings-breadcrumbs"
                                    />
                                    <label class="lbl" for="ace-settings-breadcrumbs">
                                        Fixed Breadcrumbs</label
                                    >
                                </div>

                                <div class="ace-settings-item">
                                    <input
                                            type="checkbox"
                                            class="ace ace-checkbox-2"
                                            id="ace-settings-rtl"
                                    />
                                    <label class="lbl" for="ace-settings-rtl">
                                        Right To Left (rtl)</label
                                    >
                                </div>

                                <div class="ace-settings-item">
                                    <input
                                            type="checkbox"
                                            class="ace ace-checkbox-2"
                                            id="ace-settings-add-container"
                                    />
                                    <label class="lbl" for="ace-settings-add-container">
                                        Inside
                                        <b>.container</b>
                                    </label>
                                </div>
                            </div>
                            <!-- /.pull-left -->

                            <div class="pull-left width-50">
                                <div class="ace-settings-item">
                                    <input
                                            type="checkbox"
                                            class="ace ace-checkbox-2"
                                            id="ace-settings-hover"
                                    />
                                    <label class="lbl" for="ace-settings-hover">
                                        Submenu on Hover</label
                                    >
                                </div>

                                <div class="ace-settings-item">
                                    <input
                                            type="checkbox"
                                            class="ace ace-checkbox-2"
                                            id="ace-settings-compact"
                                    />
                                    <label class="lbl" for="ace-settings-compact">
                                        Compact Sidebar</label
                                    >
                                </div>

                                <div class="ace-settings-item">
                                    <input
                                            type="checkbox"
                                            class="ace ace-checkbox-2"
                                            id="ace-settings-highlight"
                                    />
                                    <label class="lbl" for="ace-settings-highlight">
                                        Alt. Active Item</label
                                    >
                                </div>
                            </div>
                            <!-- /.pull-left -->
                        </div>
                        <!-- /.ace-settings-box -->
                    </div>
                    <!-- /.ace-settings-container -->

                    <div class="page-header">
                        <h1>
                            Danh sách toà nhà
                            <small>
                                <i class="ace-icon fa fa-angle-double-right"></i>
                                overview &amp; stats
                            </small>
                        </h1>
                    </div>
                    <!-- /.page-header -->
                </div>
                <!-- /.page-content -->

                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="widget-title">Tìm kiếm</h4>

                                <span class="widget-toolbar">
                                <a href="/admin/building-list" data-action="reload">
                                  <i class="ace-icon fa fa-refresh"></i>
                                </a>

                                <a href="#" data-action="collapse">
                                  <i class="ace-icon fa fa-chevron-up"></i>
                                </a>

                                <a href="#" data-action="close">
                                  <i class="ace-icon fa fa-times"></i>
                                </a>
                              </span>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main">
                                    <form:form action="/admin/building-list" id="listForm" method="GET" modelAttribute="modelSearch">
                                        <div class="row">
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-6">
                                                        <label> Tên toà nhà </label>
<%--                                                        <input--%>
<%--                                                                type="text"--%>
<%--                                                                id="form-field-1"--%>
<%--                                                                placeholder="Username"--%>
<%--                                                                class="form-control"--%>
<%--                                                                name="${modelSearch.name}"--%>
<%--                                                        />--%>
                                                            <form:input class="form-control" path="name"/>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <label> Diện rích sàn </label>
                                                        <form:input class="form-control" path="floorArea"/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-2">
                                                        <label> Quận </label>
                                                        <form:select path="district" class="form-control" >
                                                                <form:option value="">---Chọn quận---</form:option>
                                                                <form:options items="${district}"/>
                                                        </form:select>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label> Phường </label>
                                                        <form:input class="form-control" path="ward"/>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label> Đường </label>
                                                        <form:input class="form-control" path="street"/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-4">
                                                        <label> Số tầng hầm </label>
                                                        <form:input class="form-control" path="numberOfBasement"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <label> Hướng </label>
                                                        <form:input class="form-control" path="direction"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <label> Hạng </label>
                                                        <form:input class="form-control" path="level"/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <label> Diện tích từ </label>
                                                        <form:input class="form-control" path="areaFrom"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label> Diện tích đến </label>
                                                        <form:input class="form-control" path="areaTo"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label> Giá thuê từ </label>
                                                        <form:input class="form-control" path="rentPriceFrom"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label> Giá thuê đến </label>
                                                        <form:input class="form-control" path="rentPriceTo"/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-5">
                                                        <label> Tên quản lí </label>
                                                        <form:input class="form-control" path="managerName"/>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label> SĐT quản lí </label>
                                                        <form:input class="form-control" path="managerPhone"/>
                                                    </div>

                                                    <security:authorize access="hasRole('MANAGER')">
                                                        <div class="col-xs-2">
                                                        <label> Chọn nhân viên </label>
<%--                                                        <select--%>
<%--                                                                name="staffId"--%>
<%--                                                                id="staff"--%>
<%--                                                                class="form-control"--%>

<%--                                                        >--%>
<%--                                                            <option value="">Chọn nhân viên</option>--%>
<%--                                                            <option value="1">Nguyen Van A</option>--%>
<%--                                                            <option value="2">Nguyen Van B</option>--%>
<%--                                                            <option value="3">Le Van A</option>--%>
<%--                                                        </select>--%>
                                                            <form:select path="staffId" class="form-control" >
                                                                <form:option value="">---Chọn nhân viên---</form:option>
                                                                <form:options items="${staffs}"/>
                                                            </form:select>
                                                         </div>
                                                    </security:authorize>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-5">
                                                        <form:checkboxes path="typeCode" items="${type}"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-6">
                                                        <button type="button" class="btn btn-purple btn-sm"
                                                        id="btnSearchBuilding">
                                          <span
                                                  class="ace-icon fa fa-search icon-on-right bigger-110"
                                          ></span>
                                                            Search
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                        <div class="pull-right">
                            <a href="/admin/building-edit">
                                <button
                                        class="btn btn-app btn-success btn-xs"
                                        title="Thêm toà nhà"
                                >
                                    <svg
                                            xmlns="http://www.w3.org/2000/svg"
                                            width="20"
                                            height="20"
                                            fill="currentColor"
                                            class="bi bi-building-fill-add"
                                            viewBox="0 0 16 16"
                                    >
                                        <path
                                                d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"
                                        />
                                        <path
                                                d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v7.256A4.5 4.5 0 0 0 12.5 8a4.5 4.5 0 0 0-3.59 1.787A.5.5 0 0 0 9 9.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .39-.187A4.5 4.5 0 0 0 8.027 12H6.5a.5.5 0 0 0-.5.5V16H3a1 1 0 0 1-1-1zm2 1.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3 0v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"
                                        />
                                    </svg>
                                </button>
                            </a>

                            <security:authorize access="hasRole('MANAGER')">
                                <button
                                    class="btn btn-app btn-danger btn-xs"
                                    title="Xoá toà nhà"
                                    id="btnDeleteBuilding"
                            >
                                <svg
                                        xmlns="http://www.w3.org/2000/svg"
                                        width="20"
                                        height="20"
                                        fill="currentColor"
                                        class="bi bi-building-dash"
                                        viewBox="0 0 16 16"
                                >
                                    <path
                                            d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"
                                    />
                                    <path
                                            d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"
                                    />
                                    <path
                                            d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"
                                    />
                                </svg>
                            </button>
                            </security:authorize>
                        </div>
                    </div>
                </div>
                <!-- /.span -->

                <div class="hr hr-20 hr-double"></div>
        <!-- Table list building -->
                <div class="row">
            <div class="col-xs-12">
                <display:table
                        name="${modelSearch.listResult}"
                        id="tableList"
                        requestURI="building-list"
                partialList="true"
                size="${modelSearch.totalItems}"
                pagesize="${modelSearch.maxPageItems}"
                class="table table-striped table-bordered table-hover"
                htmlId="buildingList"
                >
                <display:column title="" class="center">
                    <label class="pos-rel">
                        <input type="checkbox" class="ace" value="${tableList.id}" id="id"/>
                        <span class="lbl"></span>
                    </label>
                </display:column>
                <display:column title="Tên toà nhà" property="name"/>
                <display:column title="Địa chỉ" property="address"/>
                <display:column title="Số tầng hầm" property="numberOfBasement"/>
                <display:column title="Tên quản lí" property="managerName"/>
                <display:column title="Số điện thoại quản lí" property="managerPhone"/>
                <display:column title="Diện tích sàn" property="floorArea"/>
                <display:column title="Diện tích thuê" property="rentArea"/>
                <display:column title="Diện tích trống" property="emptyArea"/>
                <display:column title="Giá thuê" property="rentPrice"/>
                <display:column title="Phí dịch vụ" property="serviceFee"/>
                <display:column title="Phí môi giới" property="brokerageFee"/>

                <display:column title="Thao tác">
                    <div class="hidden-sm hidden-xs btn-group">
                        <security:authorize access="hasRole('MANAGER')">
                            <button class="btn btn-xs btn-success" onclick="assignmentBuilding(${tableList.id})"
                                    title="Giao toà nhà">
                                <i class="ace-icon fa fa-users bigger-120"></i>
                            </button>
                        </security:authorize>
                        <a href="/admin/building-edit-${tableList.id}" class="btn btn-xs btn-info"
                           title="Sửa thông tin">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </a>
                        <security:authorize access="hasRole('MANAGER')">
                            <button class="btn btn-xs btn-danger" onclick="deleteBuilding(${tableList.id})"
                                    title="Xoá toà nhà">
                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                            </button>
                        </security:authorize>
                    </div>
                </display:column>
                </display:table>
            </div>
        </div>
                </div>
            <div
                    class="modal fade"
                    id="assigmentBuildingModal"
                    tabindex="-1"
                    role="dialog"
                    aria-labelledby="exampleModalLabel"
                    aria-hidden="true"
            >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Danh sách nhân viên</h5>
                            <button
                                    type="button"
                                    class="close"
                                    data-dismiss="modal"
                                    aria-label="Close"
                            >
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table
                                    id="staffList"
                                    class="table table-striped table-bordered table-hover"
                            >
                                <thead>
                                <tr>
                                    <th class="center">
                                        <label class="pos-rel">
                                            <input type="checkbox" class="ace"/>
                                            <span class="lbl"></span>
                                        </label>
                                    </th>
                                    <th>Tên nhân viên</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <input type="hidden" id="buildingId" value="">
                        </div>
                        <div class="modal-footer">
                            <button
                                    type="button"
                                    class="btn btn-secondary"
                                    data-dismiss="modal"
                            >
                                Huỷ thao tác
                            </button>
                            <button type="button" class="btn btn-primary" id="btnAssignBuilding">
                                Giao toà nhà
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function assignmentBuilding(buildingId){
                console.log('Id building: '+buildingId);
                $('#assigmentBuildingModal').modal();
                $('#buildingId').val(buildingId);
                loadStaff(buildingId);
            }

            function loadStaff(buildingId){
                $.ajax({
                    type: "GET",
                    url : "/api/buildings/" + buildingId + '/staffs',
                    // data: JSON.stringify(json),
                    dataType: "json",
                    // contentType: "application/json",
                    success : function(response){
                        var row = '';
                        $.each(response.data, (index, item) => {
                            var checked = item.checked === "checked" ? 'checked' : '';
                            row += '<tr>';
                            row += '<td class="center"><input type="checkbox" value="' + item.staffId + '" id="checkbox_' + item.staffId + '" class="center" ' + checked + ' /></td>';
                            row += '<td class="center">' + item.fullName + '</td>';
                            row += '</tr>';
                        });
                        $('#staffList tbody').html(row);
                        console.log("Success");
                    },
                    error : function(response){
                        console.log("Failed");
                    }
                });
            }

            $('#btnAssignBuilding').click(function(e){
               e.preventDefault();
               var json = {};
               json['buildingId'] = $('#buildingId').val();
               var staffIds = $('#staffList').find('tbody input[type=checkbox]:checked').map(function(){
                  return $(this).val();
               }).get();
               json['staffs'] = staffIds;
               if(json['buildingId'] == ''){
                   alert('Id Not Found');
               }else {
                   assignBuilding(json);
               }
            });

            $('#btnDeleteBuilding').click(function(e){
                e.preventDefault();
                var buildingIDs = $('#buildingList').find('tbody input[type = checkbox]:checked').map(function(){
                    return $(this).val();
                }).get();
                console.log(buildingIDs);
                if(buildingIDs == ''){
                    alert('No Buildings Selected');
                }
                else{
                    deleteBuilding(buildingIDs);
                }
            });

            function deleteBuilding(id){
                if(id == ''){
                    alert('Id Not Found');
                }else {
                    deleteBuildings(id);
                }
            }

            function deleteBuildings(ids){
                //Gửi request xuống server
                $.ajax({
                    type: "DELETE",
                    url : "/api/buildings/" + ids,
                    // data: JSON.stringify(json),
                    dataType: "json",
                    // contentType: "application/json",
                    success : function(response){
                        alert("Deleted Success!")
                        window.location.href=("/admin/building-list")
                    },
                    error : function(response){
                        alert("Deleted Failed!")
                    }
                });
            }
            function assignBuilding(json){
                //Gửi request xuống server
                $.ajax({
                    type: "POST",
                    url : "/api/assign/",
                    data: JSON.stringify(json),
                    dataType: "json",
                    contentType: "application/json",
                    success : function(response){
                        alert("Updated Assignment")
                        window.location.href=("/admin/building-list")
                    },
                    error : function(response){
                        alert("Failed Updated Assignment");
                    }
                });
            }
            $('#btnSearchBuilding').click(function(e){
                e.preventDefault();
                $('#listForm').submit();
            });
        </script>
</body>
</html>
