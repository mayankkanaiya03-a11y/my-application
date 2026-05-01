</body><%@ page contentType="text/html;charset=UTF-8" language="java" %>
       <% taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

       <html>

       <body>
           <form:form method="post" action="course" modelAttribute="model" >

               <form:input type="text" path="studentName" />
               <form:errors path="studentName" style="color:red" />

               <form:input type="number" path="age" />
               <form:errors path="age" style="color:red" />

               <form:input type="text" path="contactEmail" />
               <form:errors path="contactEmail" style="color:red" />

               <form:select type="text" path="courseTitle" >
                   <form:options items="${courses}"
               </form:select>
               <form:errors path="courseTitle" style="color:red" />

               <form:input type="date" path="enrollmentDate" />
               <form:errors path="enrollmentDate" style="color:red" />

               <form:input type="submit" />

           </form:form>
       </body>
       </html>
</html>