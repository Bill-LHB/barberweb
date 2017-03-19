<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <title>jqPaginator</title>
    <link type="text/css" rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/css/bootstrap.min.css"/>
</head>





<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jqPaginator.js"></script>
<script type="text/javascript" src="js/jqPaginator.min.js"></script>
<script type="text/javascript">

$('.pagination').jqPagination({
	  link_string : '/?page={page_number}',
	  current_page: 5, //设置当前页 默认为1
	  max_page : 40, //设置最大页 默认为1
	  page_string : '当前第{current_page}页,共{max_page}页',
	  paged : function(page) {
	      //回发事件。。。
	      }
	});
	
    $.jqPaginator('#pagination1', {
        totalPages: 100,
        visiblePages: 10,
        currentPage: 3,
        onPageChange: function (num, type) {
            $('#p1').text(type + '：' + num);
        }
    });
    $.jqPaginator('#pagination2', {
        totalPages: 100,
        visiblePages: 10,
        currentPage: 3,
        prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
        next: '<li class="next"><a href="javascript:;">Next</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
            $('#p2').text(type + '：' + num);
        }
    });
</script>
<body style="padding:10px;">
<div class="pagination">
  <a href="#" class="first" data-action="first">«</a>
  <a href="#" class="previous" data-action="previous">‹</a>
  <input type="text" readonly="readonly" data-max-page="40" />
  <a href="#" class="next" data-action="next">›</a>
  <a href="#" class="last" data-action="last">»</a>
<!-- </div>
    <p id="p1"></p>
    <ul class="pagination" id="pagination1"></ul>
    <p id="p2"></p>
    <ul class="pagination" id="pagination2"></ul>
</body> -->
</html>