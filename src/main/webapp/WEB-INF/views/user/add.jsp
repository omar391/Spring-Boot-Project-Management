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
                <h3 class="card-title">Add User</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <!-- <form role="form"> -->
                <div class="card-body">
                
                
                <input type="hidden"  name="userId" id="userId">
                  <div class="form-group">
                    <label for="Name">Name</label>
                    <input type="text" class="form-control"  required id="name" name="name" placeholder="Enter name">
                  </div>
                  <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" required id="email"  name="email" placeholder="Email">
                  </div>
                  
                     <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" required id="phone" name="phone" placeholder="Phone">
                  </div>
                  
                   <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" required id="password" name="password" placeholder="Password">
                  </div>
                  
                   <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" required id="address" name="address" placeholder="Address">
                  </div>
                  
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit"  class="btn btn-primary" onclick="submit();">Submit</button>
                  
                  <button class="btn btn-primary" onclick="window.location.href='/admin/viewUser';">View User</button>
                  
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
    <jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>


<script type="text/javascript">
data = "";
submit = function(){

	$.ajax({
	url:'saveOrUpdate',
	type:'POST',
	data:{userId:$("#userId").val(),
		name:$('#name').val(),
		email:$('#email').val(),
		phone:$('#phone').val(),
		password:$('#password').val(),
		address:$('#address').val()},
		
	success: function(response){
	alert(response.message);
	load();
	}
	});
	}
delete_ = function(id){
$.ajax({
url:'delete',
type:'POST',
data:{user_id:id},
success: function(response){
alert(response.message);
load();
}
});
}


edit = function (index){
$("#user_id").val(data[index].user_id);
$("#name").val(data[index].user_name);
$("#email").val(data[index].email);

}


load = function(){
$.ajax({
url:'list',
type:'POST',
success: function(response){
data = response.data;
$('.tr').remove();
for(i=0; i<response.data.length; i++){
$("#example1").append("<tr class='tr'> <td> "+response.data[i].name+" </td> <td> "+response.data[i].email+" </td> <td> "+response.data[i].phone+" </td>  <td> "+response.data[i].password+" </td>  <td> "+response.data[i].address+" </td> <td> <a href='#' onclick= edit("+response.data[i].userId+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].userId+");'> Delete </a>  </td> </tr>");
}
}
});

}

</script>
</body>
</html>
