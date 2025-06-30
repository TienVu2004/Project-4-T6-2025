<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/27/2025
  Time: 1:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
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
                <form:form class="form-horizontal" role="form" id="form-edit" action="/admin/building-edit" method="GET" modelAttribute="buildingEdit">
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Tên toà nhà</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="name"/>
                            <span class="error-message" style="color:red" id="name"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Quận</label>
                        <div class="col-xs-2">
                            <form:select path="district" class="form-control" >
                                <form:option value="">---Chọn quận---</form:option>
                                <form:options items="${district}"/>
                            </form:select>
                            <span class="error-message" style="color:red" id="district"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Phường</label>
                        <div class="col-xs-8">
                           <form:input class="form-control" path="ward"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Đường</label>
                        <div class="col-xs-8">
                           <form:input class="form-control" path="street"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Kết cấu</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="structure"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Số tầng hầm</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="numberOfBasement"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Hướng</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="direction"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Hạng</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="level"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Diện tích thuê</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="rentArea"/>
                            <span class="error-message" style="color:red" id="rentArea"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Giá thuê</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="rentPrice"/>
                            <span class="error-message" style="color:red" id="rentPrice"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Mô tả giá</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="rentPriceDescription"/>
                            <span class="error-message" style="color:red" id="rentPriceDescription"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Phí dịch vụ</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="serviceFee"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Phí ô tô</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="carFee"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Phí mô tô</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="motoFee"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Phí ngoài giờ</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="overtimeFee"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Tiền điện</label>
                        <div class="col-xs-8">
                             <form:input class="form-control" path="electricityFee"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Tiền nước</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="waterFee"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Đặt cọc</label>
                        <div class="col-xs-8">
                             <form:input class="form-control" path="deposit"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Thanh toán</label>
                        <div class="col-xs-8">
                             <form:input class="form-control" path="payment"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Thời hạn thuê</label>
                        <div class="col-xs-8">
                             <form:input class="form-control" path="rentTime"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Thời gian trang trí</label>
                        <div class="col-xs-8">
                            <form:input class="form-control" path="decorationTime"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Tên quản lí</label>
                        <div class="col-xs-8">
                             <form:input class="form-control" path="managerName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">SĐT quản lí</label>
                        <div class="col-xs-8">
                             <form:input class="form-control" path="managerPhone"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label"> Loại toà nhà</label>
                        <div class="col-xs-8">
                            <form:checkboxes path="typeCode" items="${type}"/>
                            <span class="error-message" style="color:red" id="typeCode"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Phí môi giới</label>
                        <div class="col-xs-8">
                             <form:input class="form-control" path="brokerageFee"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 no-padding-right control-label">Hình đại diện</label>
                        <input class="col-sm-3 no-padding-right control-label" type="file" id="uploadImage" accept="image/*"/>
                        <div class="col-sm-9">
                            <c:if test="${not empty buildingEdit.image}">
                                <c:set var="imagePath" value="${buildingEdit.image}"/>
                                <img src="${imagePath}" id="viewImage" width="300px" height="300px" style="margin-top: 50px">
                            </c:if>
                            <c:if test="${empty buildingEdit.image}">
                                <img src="/admin/image/default.png" id="viewImage" width="300px" height="300px">
                            </c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Ghi chú</label>
                        <div class="col-xs-8">
                             <form:input class="form-control" path="note"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label"></label>
                        <div class="col-xs-9">
                        <c:if test="${not empty buildingEdit.id}">
                            <button type="button" class="btn btn-primary" id="btnAddBuilding">
                                Cập nhật thông tin
                            </button>
                        </c:if>
                        <c:if test="${empty buildingEdit.id}">
                            <button type="button" class="btn btn-primary" id="btnAddBuilding">
                                Thêm toà nhà
                            </button>
                        </c:if>
                            <a href="/admin/building-list">
                                <button type="button" class="btn btn-danger">
                                    Huỷ thao tác
                                </button>
                            </a>
                        </div>
                    </div>
                    <input type="hidden" id="id" value="${buildingEdit.id}">
                </form:form>
            </div>
        </div>
    </div>
</div>
<script>
    var ok;
    function validateDateBuilding(json){
        ok=1;
        $('.error-message').html('');
        if(json['name'] === ''){
            ok=0;
            $('#name').after('<span style="color : red" class="error-message">Tên toà nhà không được trống</span>')
        }
        if(json['district'] === ''){
            ok=0;
            $('#district').after('<span style="color : red" class="error-message">Quận không được trống</span>')
        }
        if(json['typeCode'].length === 0){
            ok=0;
            $('#typeCode').html('Loại toà nhà không được trống')
        }
        if(json['rentPrice'] === ''){
            ok=0;
            $('#rentPrice').after('<span style="color : red" class="error-message">Giá thuê không được trống</span>')
        }
        if(json['rentArea'] === ''){
            ok=0;
            $('#rentArea').after('<span style="color : red" class="error-message">Diện tích thuê không được trống</span>')
        }
    }
    var imageBase64 = '';
    var imageName = '';
    $('#btnAddBuilding').click(function(){
        var formData = $('#form-edit').serializeArray();
        var json = {};
        var typeCode=[];
        $.each((formData), function(i,it){
            if(it.name != 'typeCode'){
                json[""+it.name+""] = it.value;
            }
            else{
                typeCode.push(it.value);
            }
        });
        json['typeCode'] = typeCode;
        json['id'] = $('#id').val();
        if (imageBase64 !== '') {
            json['imageBase64'] = imageBase64;
            json['imageName'] = imageName;
        }
        validateDateBuilding(json);
        if(ok===0){
            alert("Failed");
        }else{
            if(json['id'] === ''){
                addBuilding(json);
            }else{
                updateBuilding(json);
            }
        }
        console.log(json);
        console.log("OK");
    });

    $('#uploadImage').change(function (event) {
        var reader = new FileReader();
        var file = $(this)[0].files[0];
        reader.onload = function(e){
            imageBase64 = e.target.result;
            imageName = file.name; // ten hinh khong dau, khoang cach. Dat theo format sau: a-b-c
        };
        reader.readAsDataURL(file);
        openImage(this, "viewImage");
    });

    function openImage(input, imageView) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' +imageView).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    function addBuilding(json){
        //Gửi request xuống server
        $.ajax({
            type: "POST",
            url : "/api/buildings",
            data: JSON.stringify(json),
            dataType: "json",
            contentType: "application/json",
            success : function(response){
                alert("Add Building Succesfully!");
                window.location.href=("/admin/building-list");
            },
            error : function(response){
                alert("Add Building Failed!");
            }
        });
    }
    function updateBuilding(json){
        //Gửi request xuống server
        $.ajax({
            type: "PUT",
            url : "/api/buildings",
            data: JSON.stringify(json),
            dataType: "json",
            contentType: "application/json",
            success : function(response){
                alert("Updated Succesfully!")
                window.location.href=("/admin/building-list")
            },
            error : function(response){
                alert("Update Failed!")
            }
        });
    }
</script>
</body>
</html>
