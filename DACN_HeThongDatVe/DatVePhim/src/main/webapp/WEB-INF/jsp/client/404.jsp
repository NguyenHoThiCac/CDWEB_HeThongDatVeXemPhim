<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">

    <head>
        <title>Movie Ticket and Service Website | Error</title>

        <!--/*/ <th:block th:include="fragments/utils :: head"></th:block> /*/-->

    </head>
    <body>
    <!-- header-section-starts -->
    <div class="full">
        <div class="menu">
            <ul>
                <li><a href="index"><div class="hm"><i class="home1"></i><i class="home2"></i></div></a></li>
                <li><a href="videos"><div class="video"><i class="videos"></i><i class="videos1"></i></div></a></li>
                <li><a href="reviews"><div class="cat"><i class="watching"></i><i class="watching1"></i></div></a></li>
                <!-- <li><a href="ticket"><div class="bk"><i class="booking"></i><i class="booking1"></i></div></a></li> -->
            </ul>
        </div>
        <div class="main">
            <div class="error-content">
                <div class="top-header span_top">
                    <!--/*/ <th:block th:include="fragments/utils :: header"></th:block> /*/-->
                </div>
                <div class="error-404 text-center">
                    <h2>404</h2>
                    <p>Sorry this was unexpected</p>
                    <a class="b-home" href="index">Back to Home</a>
                </div>
                <div class="footer">
                    <!--/*/ <th:block th:include="fragments/utils :: footer"></th:block> /*/-->
                </div>

            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    </body>
</html>