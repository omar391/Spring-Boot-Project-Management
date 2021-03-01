<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>


    <!-- Main content -->
    <section class="content">
       <div class="container-fluid">
        <!-- Small boxes (Stat box) -->
        <div class="row">
        
        
        
        
        
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Add Task</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <!-- <form role="form"> -->
                <div class="card-body">
                
                
                <input type="hidden" id="taskId">
                  <div class="form-group">
                    <label for="Name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
                  </div>
                  <div class="form-group">
                    <label for="description">Description</label>
                    <textarea type="text" class="form-control" id="description" name="description" placeholder="Description"></textarea>
                  </div>
                  
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit"  class="btn btn-primary" onclick="submit();">Submit</button>
                  
                  <button class="btn btn-primary" onclick="window.location.href='/admin/viewProject';">View Project</button>
                  
                </div>
             <!--  </form> -->
            </div>
            <!-- /.card -->
            
            
            
            
        
        
        
        
        
        
        
        </div>
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>




<script type="text/javascript">
data = "";
submit = function(){

$.ajax({
url:'saveProject',
type:'POST',
data:{projectId:$("#projectId").val(),name:$('#name').val(),description:$('#description').val()},
success: function(response){
alert(response.message);
load();
}
});
}

load = function(){
$.ajax({
url:'list',
type:'POST',
success: function(response){
data = response.data;
$('.tr').remove();
for(i=0; i<response.data.length; i++){
$("#table").append("<tr class='tr'> <td> "+response.data[i].user_name+" </td> <td> "+response.data[i].email+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].user_id+");'> Delete </a>  </td> </tr>");
}
}
});

}

</script>
</body>
</html>
