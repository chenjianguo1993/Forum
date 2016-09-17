网站地址:http://localhost:8080/Forum/servlet/IndexUIServlet

1.div图层被挡住了用  z-index:999 ,absolute之后是有z轴的排版的，它被盖在下面了，z-index是权值，加大就叠在上面

2.UEditor 第一次加载正常，第二次无法正常加载问题
解答：jQuery(function($) {
    UE.delEditor('_editor');
    var ue = UE.getEditor('_editor');
)}













