<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/23/2025
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Chỉnh sửa thông tin khách hàng</title>
</head>
<body>
    <div class="main-content" style="font-family: 'Times New Roman', Times, serif;">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check("breadcrumbs", "fixed");
                } catch (e) {}
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
                <form:form class="form-horizontal" role="form" id="form-edit" action="/admin/cutomer-edit" method="GET" modelAttribute="customerEdit">
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Tên khách hàng</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="fullName"/>
                            <span class="error-message" style="color:red" id="fullName"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Số điện thoại</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="phone"/>
                            <span class="error-message" style="color:red" id="phone"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Email</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="email"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Tên công ty</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="companyName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Nhu cầu</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="demand"/>
                            <span class="error-message" style="color:red" id="demand"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Trạng thái xử lí</label>
                        <div class="col-xs-4">
                            <form:select path="status" class="form-control" >
                                <form:option value="">---Chọn trạng thái---</form:option>
                                <form:options items="${status}"/>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label"></label>
                        <div class="col-xs-9">
                            <c:if test="${not empty customerEdit.id}">
                                <button type="button" class="btn btn-primary" id="btnAddCustomer">
                                    Cập nhật thông tin
                                </button>
                            </c:if>
                            <c:if test="${empty customerEdit.id}">
                                <button type="button" class="btn btn-primary" id="btnAddCustomer">
                                    Thêm thông tin
                                </button>
                            </c:if>
                            <a href="/admin/customer-list">
                                <button type="button" class="btn btn-danger">
                                    Huỷ thao tác
                                </button>
                            </a>
                        </div>
                    </div>
                    <input type="hidden" id="id" value="${customerEdit.id}">
                </form:form>
                <c:if test="${not empty customerEdit.id}">
                    <c:forEach var="item" items="${transactionType}">
                        <div class="col-xs-12">
                            <h2 class="smaller lighter blue">
                                    ${item.value}
                                <button class="btn btn-md btn-success pull-right" title="Thêm giao dịch"
                                        onclick="addTransaction('${item.key}', ${customerEdit.id})">
                                    <i class="ace-icon glyphicon glyphicon-plus small-80"></i>Thêm giao dịch
                                </button>
                            </h2>
                            <div class="hr hr-16 dotted hr-dotted"></div>
                        </div>
                        <c:if test="${item.key == 'CSKH'}">
                            <div class="row">
                                <div class="col-xs-12">
                                    <table id="CSKH-list" class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>Ngày tạo</th>
                                            <th>Người tạo</th>
                                            <th>Ngày sửa</th>
                                            <th>Người sửa</th>
                                            <th>Chi tiết giao dịch</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="transaction" items="${CSKH}">
                                            <tr>
                                                <td>${transaction.createdDate}</td>
                                                <td>${transaction.createdBy}</td>
                                                <td>${transaction.modifiedDate}</td>
                                                <td>${transaction.modifiedBy}</td>
                                                <td>${transaction.note}</td>
                                                <td>
                                                    <a class="btn btn-xs btn-info" onclick="updateTransaction('CSKH', ${customerEdit.id}, ${transaction.id},  '${transaction.note}')">
                                                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                    </a>
                                                    <security:authorize access="hasAnyRole('MANAGER')">
                                                        <button class="btn btn-xs btn-danger" title="Xóa tòa nhà" onclick="deleteTransaction(${transaction.id}, 'CSKH', ${customerEdit.id})">
                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </button>
                                                    </security:authorize>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${item.key == 'DDX'}">
                            <div class="row">
                                <div class="col-xs-12">
                                    <table id="CSKH-list" class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>Ngày tạo</th>
                                            <th>Người tạo</th>
                                            <th>Ngày sửa</th>
                                            <th>Người sửa</th>
                                            <th>Chi tiết giao dịch</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="transaction" items="${DDX}">
                                            <tr>
                                                <td>${transaction.createdDate}</td>
                                                <td>${transaction.createdBy}</td>
                                                <td>${transaction.modifiedDate}</td>
                                                <td>${transaction.modifiedBy}</td>
                                                <td>${transaction.note}</td>
                                                <td>
                                                    <a class="btn btn-xs btn-info" onclick="updateTransaction('DDX', ${customerEdit.id}, ${transaction.id},  '${transaction.note}')">
                                                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                    </a>
                                                    <security:authorize access="hasAnyRole('MANAGER')">
                                                        <button class="btn btn-xs btn-danger" title="Xóa tòa nhà" onclick="deleteTransaction( ${transaction.id}, 'DDX', ${customerEdit.id})">
                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                        </button>
                                                    </security:authorize>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </c:if>
                <div
                    class="modal fade"
                    id="detailCustomer"
                    tabindex="-1"
                    role="dialog"
                    aria-labelledby="exampleModalLabel"
                    aria-hidden="true"
            >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Nhập thông tin giao dịch</h5>
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
<%--                                <thead>--%>
<%--                                <tr>--%>
<%--                                    <th>Thoong tin giao dịch</th>--%>
<%--                                    <th>input</th>--%>
<%--                                </tr>--%>
<%--                                </thead>--%>
                                <tbody>
                                    <tr>
                                        <td>Chi tiết giao dịch</td>
                                        <td><input type="text" name="note" class="form-control" id="note"/></td>
                                    </tr>
                                    <input type="hidden" id="customerId" value="">
                                    <input type="hidden" id="code" value="">
                                    <input type="hidden" id="transactionId" value="">
                                </tbody>
                            </table>
<%--                            <input type="hidden" id="buildingId" value="">--%>
                        </div>
                        <div class="modal-footer">
                            <button
                                    type="button"
                                    class="btn btn-secondary"
                                    data-dismiss="modal"
                            >
                                Huỷ thao tác
                            </button>
                            <button type="button" class="btn btn-primary" id="btnAddOrUpdateTransaction">
                                Thêm thông tin
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
</div>
    <script>
        var ok;
        function validateDateCustomer(json){
            ok=1;
            $('.error-message').html('');
            if(json['fullName'] === ''){
                ok=0;
                $('#fullName').after('<span style="color : red" class="error-message">Tên khách hàng không được trống</span>')
            }
            if(json['phone'] === ''){
                ok=0;
                $('#phone').after('<span style="color : red" class="error-message">SĐT khách hàng không được trống</span>')
            }
            if(json['demand'] === ''){
                ok=0;
                $('#demand').after('<span style="color : red" class="error-message">Yêu cầu không được trống</span>')
            }
        }

        function deleteTransaction(id, code, customerId){
            if(!id){
                alert('Id Not Found');
            }else {
                deleteTransactions(id, code, customerId);
            }
        }

        function deleteTransactions(id, code, customerId){
            //Gửi request xuống server
            $.ajax({
                type: "DELETE",
                url: "/api/transactions/"+ id + "/" + encodeURIComponent(code) + "/" + customerId,
                // data: JSON.stringify(json),
                dataType: "json",
                // contentType: "application/json",
                success : function(response){
                    alert("Deleted Success!")
                    window.location.href=("/admin/customer-edit-" + customerId);
                },
                error : function(response){
                    alert("Deleted Failed!")
                }
            });
        }

        $('#btnAddCustomer').click(function(){
            var formData = $('#form-edit').serializeArray();
            var json = {};
            $.each((formData), function(i,it){
                json[it.name] = it.value;
            });
            json['id'] = $('#id').val();
            validateDateCustomer(json);
            if(ok===0){
                alert("Failed");
            }else{
                if(json['id'] === ''){
                    addCustomer(json);
                }else{
                    updateCustomer(json);
                }
            }
            console.log(json);
            console.log("OK");
        });

        function addCustomer(json){
            $.ajax({
                type: "POST",
                url : "/api/customers",
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success : function(response){
                    alert("Add Customer Succesfully!");
                    window.location.href=("/admin/customer-list");
                },
                error : function(response){
                    alert("Add Customer Failed!");
                }
            });
        }
        function updateCustomer(json){
            //Gửi request xuống server
            $.ajax({
                type: "PUT",
                url : "/api/customers",
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success : function(response){
                    alert("Updated Succesfully!")
                    window.location.href=("/admin/customer-list");
                },
                error : function(response){
                    alert("Update Failed!")
                }
            });
        }

        function addTransaction(code, customerId){
            $('#detailCustomer').modal();
            $('#customerId').val(customerId);
            $('#code').val(code);
        }

        function updateTransaction(code, customerId, transactionId, note) {
            console.log('updateTransaction called:', code, customerId, transactionId, note);
            $('#detailCustomer').modal();
            $('#customerId').val(customerId);
            $('#code').val(code);
            $('#transactionId').val(transactionId);
            $('#note').val(note);
        }

        $('#btnAddOrUpdateTransaction').click(function(e){
            e.preventDefault();
            var json = {};
            json['id'] = $('#transactionId').val();
            json['code'] = $('#code').val();
            json['note'] = $('#note').val();
            json['customerId'] = $('#customerId').val();
            if(json['note'] ===''){
                alert("Vui lòng nhập thông tin giao dịch!");
            }else {
                if(!json.id || json.id.trim() === ''){
                    addTransactions(json);
                }else{
                    updateTransactions(json);
                }
            }
            console.log(json);
            console.log("OK");
        });

        function addTransactions(json){
            $.ajax({
                type: "POST",
                url : "/api/transactions",
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success : function(response){
                    alert("Add Customer Succesfully!");
                    window.location.href=("/admin/customer-edit-" + json.customerId);
                },
                error : function(response){
                    alert("Add Customer Failed!");
                }
            });
        }
        function updateTransactions(json){
            //Gửi request xuống server
            $.ajax({
                type: "PUT",
                url : "/api/transactions",
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success : function(response){
                    alert("Updated Succesfully!")
                    window.location.href=("/admin/customer-edit-" + json.customerId);
                },
                error : function(response){
                    alert("Update Failed!")
                }
            });
        }
    </script>
</body>
</html>
