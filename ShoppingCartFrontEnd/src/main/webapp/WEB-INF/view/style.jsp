<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<style style="text/css">
.horizontally {
 height: 50px;
 width:  1000px;	
 overflow: hidden;
 position: relative;
 background: black;
 color: white;
 border: 1px solid orange;
    }
.horizontally p {
 position: absolute;
 width: 100%;
 height: 100%;
 margin: 0;
 line-height: 50px;
 text-align: center;
text-shadow: 3px 2px red;
font-style: italic;
 /* Starting position */
 -moz-transform:translateX(50%);
 -webkit-transform:translateX(50%);	
 transform:translateX(50%);
 /* Apply animation to this element */	
 -moz-animation: horizontally 10s linear infinite alternate;
 -webkit-animation: horizontally 10s linear infinite alternate;
 animation: horizontally 10s linear infinite alternate;
}
/* Move it (define the animation) */
@-moz-keyframes horizontally {
 0%   { -moz-transform: translateX(50%); }
 100% { -moz-transform: translateX(-50%); }
}
@-webkit-keyframes horizontally {
 0%   { -webkit-transform: translateX(50%); }
 100% { -webkit-transform: translateX(-50%); }
}
@keyframes horizontally {
 0%   { 
 -moz-transform: translateX(50%); /* Browser bug fix */
 -webkit-transform: translateX(50%); /* Browser bug fix */
 transform: translateX(50%); 		
 }
 100% { 
 -moz-transform: translateX(-50%); /* Browser bug fix */
 -webkit-transform: translateX(-50%); /* Browser bug fix */
 transform: translateX(-50%); 
 }
}
</style>
<div class="horizontally">
<p><b>People who love to eat are always welcome here.<b></p>
</div>

</body>
</html>