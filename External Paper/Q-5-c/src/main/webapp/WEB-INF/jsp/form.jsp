<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <form:form method="post" action="feedback" modelAttribute="model" >
        Student Name: <form:input type="text" path="studentName" /><br/><br/>

        Course Name: <form:select path="courseName" >
            <!-- Close the options tag properly -->
            <form:options items="${courses}" />
        </form:select><br/><br/>

        Feedback Rating: <form:select path="feedbackRating" >
            <!-- Close the options tag properly -->
            <form:options items="${ratings}" />
        </form:select><br/><br/>

        Comments: <form:input type="text" path="comments" /><br/><br/>

        <!-- Use standard HTML input for the submit button -->
        <input type="submit" value="Submit Feedback" />
    </form:form>
</body>
</html>