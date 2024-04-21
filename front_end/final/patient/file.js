document.querySelector('.menu-toggle').onclick = function() {
    var nav = document.querySelector('#nav1');
    if (nav.style.display === 'block') {
        nav.style.display = 'none';
    } else {
        nav.style.display ='block';
    }
    var usr=sessionStorage.getItem('jwt');
    console.log(usr);
};

document.getElementById('notification-div').style.display = 'none';
document.querySelector('.notification-toggle').onclick = function() {
    var nav = document.querySelector('#notification-div');
    var tmp = document.querySelector('#account-div');
    if (nav.style.display === 'block') {
        nav.style.display = 'none';
    } else {
        nav.style.display ='block';
        tmp.style.display = 'none';
    }
};
document.getElementById('account-div').style.display = 'none';
document.querySelector('.account-toggle').onclick = function() {
    var nav = document.querySelector('#account-div');
    var tmp = document.querySelector('#notification-div');
    if (nav.style.display === 'block') {
        nav.style.display = 'none';
    } else {
        nav.style.display ='block';
        tmp.style.display = 'none';
    }
};
function func1(){
    document.getElementById('section').innerHTML = `
    <h1>Thông tin cá nhân</h1>     
    <form class="form-inline">
    <div id="benhnhanInfo"></div>
    <label for="id">Mã bệnh nhân</label>
    <div id="id" class="form-control"></div>
    <label for="name">Họ và tên:</label>
    <div id="name" class="form-control"></div>
    <label for="gender">Giới tính:</label>
    <div id="gender" class="form-control"></div>
    <label for="phone">Số điện thoại:</label>
    <div id="phone" class="form-control"></div>
    <label for="age">Tuổi:</label>
    <div id="age" class="form-control"></div>
    <label for="address">Địa chỉ:</label>
    <div id="address" class="form-control"></div>

    <label >Lịch sử bệnh án:</label><br><br>     
    <div id="pivot" id="pivot1" style="margin-left:50px;"></div>
    </form>
    `
        var token= sessionStorage.getItem('jwt')
        var userId=sessionStorage.getItem('id')
        try{
        fetch('http://localhost:8080/profile/patient/getprofile/'+userId,{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
                "Authorization":"Bearer "+token
            }
        })
        .then(function(response){
            return response.json();
        })
        .then(function(data){
            document.getElementById('id').innerText=data.id;
            console.log(data.id)
            document.getElementById('name').innerText=data.name;
            document.getElementById('phone').innerText=data.phone;
            document.getElementById('gender').innerText=data.gender;
            document.getElementById( 'age').innerText=data.age;
            document.getElementById('address').innerHTML=data.address.street+"-"+
            data.address.town+"-"+data.address.province+"-"+data.address.town
            const medical= data.medicalRecordList;
    
            const tableBody = document.querySelector("#section #pivot");
            medical.forEach(record=>{
                const row = document.createElement("div");
                row.innerHTML = `
                <label>Thời gian bị bệnh:</label>
                    <div id="sicktime" type="date" class="form-control" name="medicalrecord.time" >${record.name}</div>
                    <label>Tên bệnh:</label>
                    <div id="disease"type="text" class="form-control" name="medicalrecord.name" >${record.time}</div>
                    <label>Đã được điều trị:</label>
                    <div id="treatmented" type="text" class="form-control" name="medicalrecord.treatment" >${record.treatment ? "Yes" : "No"}</div>
                    <br><br><br>
        `;
        tableBody.appendChild(row);
            }) 
        })
    }catch(error){
        alert('Lỗi kết nối đến server: ' + error);
    }
}
function func2(){
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';

    document.getElementById('section').innerHTML = `
    <h1>Chỉnh sửa thông tin</h1>     
    <form class="form-inline">
    <div id="benhnhanInfo"></div>
    </form>
        `
        var benhnhan = 
            { id: 1, name: 'AAA', gender: 'Nam', phone: 'A', age: 15, address: 'A',medicalrecord:{time:"2020-02-02",name:'aa',treament:'aaaaa'} };

        // Function to display benhnhan information
        function displaybenhnhanInfo() {
            const benhnhanInfo = document.getElementById('benhnhanInfo');
            benhnhanInfo.innerHTML = '';

            const benhnhanElement = document.createElement('div');
                benhnhanElement.innerHTML = `
                        <label for="name">Họ và tên:</label>
                        <input type="text" class="form-control" name="name" value=${benhnhan.name}>
                        <label for="gender">Giới tính:</label>
                        <input type="text" class="form-control" name="gender" value=${benhnhan.gender}>
                        <label for="phone">Số điện thoại:</label>
                        <input type="text" class="form-control" name="phone" value=${benhnhan.phone}>
                        <label for="age">Tuổi:</label>
                        <input type="number" class="form-control" name="age" value=${benhnhan.age}>
                        <label for="address">Địa chỉ:</label>
                        <input type="text" class="form-control" name="address" value=${benhnhan.address}>
                        <br>                      
                        <button class="button" type="submit">Sửa thông tin</button>     
                        <br><br>   
                `;
                benhnhanInfo.appendChild(benhnhanElement);
        }
        displaybenhnhanInfo();
    
}
function func3(){
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';

    document.getElementById('section').innerHTML=`
    <h1>Hồ sơ khám bệnh</h1>       
    <form class="form-inline">
    <div id="medicaldetailInfo"></div>
    </form>
    `;
    // <script>
        //Tao du lieu tam
        const medicaldetails = [
            {detail:{ id: 1, major: 'AAA', nameofDisease: 'Nam', patientState: 'A', inProgress: 'A', prescription: 'A',medicalSchedules:{time:'3/2/2022',detail:'tai kham',done:'a',} }, info:{patientID:'a',doctorId:'a'}},
            {detail:{ id: 2, major: 'AA', nameofDisease: 'Nam', patientState: 'A', inProgress: 'A', prescription: 'A',medicalSchedules:{time:'3/2/2022',detail:'tai kham',done:'a',} }, info:{patientID:'a',doctorId:'b'}},
            {detail:{ id: 3, major: 'AA', nameofDisease: 'Nam', patientState: 'A', inProgress: 'A', prescription: 'A',medicalSchedules:{time:'3/2/2022',detail:'tai kham',done:'a',} }, info:{patientID:'c',doctorId:'a'}},
            {detail:{ id: 4, major: 'AA', nameofDisease: 'Nam', patientState: 'A', inProgress: 'A', prescription: 'A',medicalSchedules:{time:'3/2/2022',detail:'tai kham',done:'a',} }, info:{patientID:'a',doctorId:'d'}},
        ];
        
        // Function to display medicaldetail information
        function displaymedicaldetailInfo() {
            const medicaldetailInfo = document.getElementById('medicaldetailInfo');
            medicaldetailInfo.innerHTML = '';
            
            medicaldetails.forEach(medicaldetail => {
                if (medicaldetail.info.patientID==="a")
                {
                    const medicaldetailElement = document.createElement('div');
                medicaldetailElement.innerHTML = `
                        <label for="id">Mã bệnh nhân:</label>
                        <div class="form-control">${medicaldetail.detail.id}</div>
                        <label for="major">Khoa:</label>
                        <div class="form-control">${medicaldetail.detail.major}</div>
                        <label for="nameofDisease">Tên bệnh:</label>
                        <div class="form-control">${medicaldetail.detail.nameofDisease}</div>
                        <label for="patientState">Tình trạng bệnh nhân:</label>
                        <div class="form-control">${medicaldetail.detail.patientState}</div>
                        <label for="inProgress">Đang điều trị:</label>
                        <div class="form-control">${medicaldetail.detail.inProgress}</div>
                        <label for="medicalSchedules">Hẹn tái khám:</label><br>
                        <label for="medicalSchedules.time">Ngày tái khám:</label>
                        <div class="form-control">${medicaldetail.detail.medicalSchedules.time}</div>
                        <label for="medicalSchedules.detail">Chi tiết:</label>
                        <div class="form-control">${medicaldetail.detail.medicalSchedules.detail}</div>                        
                        <label for="medicalSchedules.done">Đã tái khám:</label>
                        <div class="form-control">${medicaldetail.detail.medicalSchedules.done}</div>
                        <br><br><br>
                        <input onclick="window.location.href='medicaldetail.info.doctorId';" type="submit" class="button" value="Xem thông tin bệnh nhân">    
                                               
         
                `;
                medicaldetailInfo.appendChild(medicaldetailElement);}
            });
        }
        displaymedicaldetailInfo();
    ;
    ;
    
}
function func4() {
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';
    
    document.getElementById('section').innerHTML = `
    <h1>Đặt lịch khám</h1>     
                                    
    `

}
