<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/20/2025
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Đăng ký</title>
    <style>
        .container {
            background-color: #2c7659 !important;
        }
    </style>
</head>
<body>
    <section class="vh-100 gradient-custom form-register" style="background-color: #2c7659; width: 100vw; height: 100vh; margin: 0; padding: 0;">
        <div class="container ">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card text-white" style="border-radius: 1rem; background-color: #35bf76;">
                    <div class="card-body p-2 px-5 text-center">
                        <div class="md-5 md-4 mt-4 pb-2">
                            <form:form modelAttribute="user" method="GET" action="/register" class="text-white" id="form-register" role="form">
                                <h2 class="fw-bold mb-2 text-uppercase">Create an account</h2>
                                <p class="text-white-50 mb-2">Please enter your Information</p>
                                <!-- Username -->
                                <div class="form-outline form-white mb-2">
                                    <label class="form-label" for="username">Fullname</label>
                                    <form:input path="fullName" id="fullname" class="form-control form-control-lg" name="fullName" placeholder="Username" />
                                    <span class="error-message" style="color:red" id="fullName"></span>
                                </div>
                                <div class="form-outline form-white mb-2">
                                    <label class="form-label" for="username">Username</label>
                                    <form:input path="userName" id="username" class="form-control form-control-lg" name="userName" placeholder="Username" />
                                    <span class="error-message" style="color:red" id="userName"></span>
                                </div>

                                <!-- Password -->
                                <div class="form-outline form-white mb-2">
                                    <label class="form-label" for="password">Password</label>
                                    <form:password path="password" id="password" class="form-control form-control-lg" name="password" placeholder="Password" />
                                    <span class="error-message" style="color:red" id="password"></span>
                                </div>

                                <!-- Repeat Password -->
                                <div class="form-outline form-white mb-2">
                                    <label class="form-label" for="confirmPassword">Repeat your password</label>
                                    <form:password path="confirmPassword" id="confirmPassword" class="form-control form-control-lg" name="confirmPassword" placeholder="Repeat Password" />
                                    <span class="error-message" style="color:red" id="confirmPassword"></span>
                                </div>

                                <!-- Checkbox -->
                                <div class="form-check d-flex justify-content-center align-items-center mb-2">
                                    <label class="form-check-label text-white m-0">
                                        <input class="form-check-input me-2" type="checkbox" id="terms" name="terms" />
                                        I agree all statements in
                                        <a href="#!" class="text-decoration-underline text-white">Terms of service</a>
                                    </label>
                                </div>

                                <!-- Submit Button -->
                                <button class="btn btn-outline-light btn-lg px-5 btn-custom" id="btnRegister" type="button">Register</button>

                                <!-- Social Links -->
                                <div class="d-flex justify-content-center text-center mt-2 pt-1">
                                    <a href="#!" class="login-extension text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                                    <a href="#!" class="login-extension text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                                    <a href="#!" class="login-extension text-white"><i class="fab fa-google fa-lg"></i></a>
                                </div>

                                <!-- Login Link -->
                                <p class="text-center text-muted mt-2 mb-0">
                                    Have already an account?
                                    <a href="/login" class="fw-bold text-body"><u style="color: white;">Login here</u></a>
                                </p>
                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </section>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        var ok;
        function validateDateCustomer(json){
            ok = 1;
            $('.error-message').html('');
            if(json['fullName'] === ''){
                ok = 0;
                $('#fullName').after('<span style="color:red" class="error-message">Họ và tên không được để trống</span>');
            }
            if(json['userName'] === ''){
                ok = 0;
                $('#userName').after('<span style="color:red" class="error-message">Tài khoản không được trống</span>');
            }
            if(json['password'] === ''){
                ok = 0;
                $('#password').after('<span style="color:red" class="error-message">Mật khẩu không được để trống</span>');
            }
            if(json['confirmPassword'] === ''){
                ok = 0;
                $('#confirmPassword').after('<span style="color:red" class="error-message">Mật khẩu không được để trống</span>');
            }
        }

        $('#btnRegister').click(function(e){
            console.log('click done');
            e.preventDefault();
            var formData = $('#form-register').serializeArray();
            var json = {};
            $.each(formData, function(i, it){
                json[it.name] = it.value;
            });
            validateDateCustomer(json);
            if(ok === 0){
                alert("Vui lòng điền đầy đủ thông tin!");
            } else {
                createAccount(json);
            }
        });

        function createAccount(json){
            $.ajax({
                type: "POST",
                url : "api/user/register",
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success : function(response){
                    alert("Tạo tài khoản thành công!");
                    window.location.href = "/register";
                },
                error : function(response){
                    alert("Tạo tài khoản thất bại!");
                }
            });
        }
    </script>
</body>
</html>
