document.querySelector('.menu-toggle').onclick = function() {
    var nav = document.querySelector('#nav1');
    if (nav.style.display === 'block') {
        nav.style.display = 'none';
    } else {
        nav.style.display ='block';
    }
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
function func1() {
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';

    document.getElementById('section').innerHTML = `
    <h1>Thông tin cá nhân</h1>   
    <form class="form-inline">    
    <div id="nhanvienInfo"></div>
    </form>
    `
        //Tao du lieu tam
        const nhanviens = [
            { id: 1, name: 'AAA', gender: 'Nam', phone: 'A', age: 'A', address: 'A',role:'doctor',part:'medicalemployee',workForm:'3/2/2022',Position:'a',Certificate:{department:'a',time:'3/2/2022',major:'a'} },
            
        ];
        
        function _Role(nhanvien)
        {
            if (nhanvien.role=="doctor")
                return "Bác sĩ";
            if (nhanvien.role=="nurse")
                return "Y tá";
            if (nhanvien.role=="functionalemployee")
                return "Nhân viên y tế";
        }
        function _Part(nhanvien)
        {
            if (nhanvien.part=="medicalemployee")
                return "Nhân viên y tế";
            if (nhanvien.role=="financialemployee")
                return "Nhân viên tài chính";
            if (nhanvien.role=="pharmacymanager")
                return "Nhân viên quản lý thuốc";
        }
        // Function to display nhanvien information
        function displaynhanvienInfo() {
            const nhanvienInfo = document.getElementById('nhanvienInfo');
            nhanvienInfo.innerHTML = '';

            nhanviens.forEach(nhanvien => {
                //if (nhanvien.role == 'doctor')
                {
                    const nhanvienElement = document.createElement('div');
                nhanvienElement.innerHTML = `
                        <label for="id">Mã nhân viên</label>
                        <div class="form-control">${nhanvien.id}</div>
                        <label for="name">Họ và tên:</label>
                        <div class="form-control">${nhanvien.name}</div>
                        <label for="gender">Giới tính:</label>
                        <div class="form-control">${nhanvien.gender}</div>
                        <label for="phone">Số điện thoại:</label>
                        <div class="form-control">${nhanvien.phone}</div>
                        <label for="age">Tuổi:</label>
                        <div class="form-control">${nhanvien.age}</div>
                        <label for="address">Địa chỉ:</label>
                        <div class="form-control">${nhanvien.address}</div>
                        <label for="role">Vai trò:</label>
                        <div class="form-control">${_Role(nhanvien)}</div>
                        <label for="part">Bộ phận:</label>
                        <div class="form-control">${_Part(nhanvien)}</div>
                        <label for="workFrom">Ngày bắt đầu làm việc:</label>
                        <div class="form-control">${nhanvien.workForm}</div>
                        <label for="Position">Chức vụ:</label>
                        <div class="form-control">${nhanvien.Position}</div>
                        <label for="Certificate">Danh sách chứng chỉ:</label><br>
                        <div style="margin-left: 50px;">   
                            <label for="Certificate.department">Đơn vị cấp chứng chỉ:</label>
                            <div class="form-control">${nhanvien.Certificate.department}</div>
                            <label for="Certificate.time">Thời gian cấp chứng chỉ:</label>
                            <div class="form-control">${nhanvien.Certificate.time}</div>
                            <label for="Certificate.major">Chuyên ngành:</label>
                            <div class="form-control">${nhanvien.Certificate.major}</div>
                        </div>   
                        <br><br><br>      
                `;
                nhanvienInfo.appendChild(nhanvienElement);}
            });
        }

        displaynhanvienInfo();

}

function func2(){
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';

    document.getElementById('section').innerHTML = `
    <h1>Chỉnh sửa thông tin</h1>     
    <form class="form-inline">
    <div id="nhanvienInfo"></div>
    </form>
        `
        var nhanvien = 
            { id: 1, name: 'AAA', gender: 'Nam', phone: 'A', age: 15, address: 'A',role:'doctor',part:'medicalemployee',workForm:"2022-03-04",Position:'a',Certificate:{department:'a',time:'3/2/2022',major:'a'} };

        // Function to display nhanvien information
        function displaynhanvienInfo() {
            const nhanvienInfo = document.getElementById('nhanvienInfo');
            nhanvienInfo.innerHTML = '';

            const nhanvienElement = document.createElement('div');
                nhanvienElement.innerHTML = `
                        <label for="name">Họ và tên:</label>
                        <input type="text" class="form-control" name="name" value=${nhanvien.name}>
                        <label for="gender">Giới tính:</label>
                        <input type="text" class="form-control" name="gender" value=${nhanvien.gender}>
                        <label for="phone">Số điện thoại:</label>
                        <input type="text" class="form-control" name="phone" value=${nhanvien.phone}>
                        <label for="age">Tuổi:</label>
                        <input type="number" class="form-control" name="age" value=${nhanvien.age}>
                        <label for="address">Địa chỉ:</label>
                        <input type="text" class="form-control" name="address" value=${nhanvien.address}>
                        <label for="role">Vai trò:</label>
                        <select class="form-select" name="role">
                            <option selected>...</option>
                            <option value="doctor">Bác sĩ</option>
                            <option value="nurse">Y tá</option>
                            <option value="functionalemployee">Nhân viên chức năng</option>
                        </select>                        
                        <label for="part">Bộ phận:</label>
                        <select class="form-select" name="part">
                            <option selected>...</option>
                            <option value="medicalemployee">Nhân viên y tế</option>
                            <option value="financialemployee">Nhân viên tài chính</option>
                            <option value="pharmacymanager">Nhân viên quản lý thuốc</option>
                            
                        </select>
                        
                        <label for="workFrom">Ngày bắt đầu làm việc:</label>
                        <input type="date" class="form-control" name="workFrom" value=${nhanvien.workForm}>
                        <label for="Position">Chức vụ:</label>
                        <input type="text" class="form-control" name="Position" value=${nhanvien.Position}> 
                        <br>                     
                        <button class="button" type="submit">Sửa thông tin</button>  
                        <br><br>
                `;
                nhanvienInfo.appendChild(nhanvienElement);
        }
            displaynhanvienInfo();
}
function func3(){
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';

    document.getElementById('section').innerHTML = `
    <h1 >Hồ sơ khám bệnh</h1>  
    <form>
    <div id="medicaldetailInfo"></div>
    </form>
    `
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
                if (medicaldetail.info.doctorId=="a")
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
                        
                        
                        <button class="button" type="submit">Xem thông tin bệnh nhân</button>       
                        <br><br><br>        
                `;
                medicaldetailInfo.appendChild(medicaldetailElement);}
            });
        }

        displaymedicaldetailInfo();
}
function func4(){
    var tmp1 = document.querySelector('#notification-div');
    var tmp2 = document.querySelector('#account-div');
    tmp1.style.display='none';
    tmp2.style.display='none';

    document.getElementById('section').innerHTML=`
    <h1>Lịch khám bệnh</h1>       
    <form class="form-inline">
    </form>
    `;
    
    
}
