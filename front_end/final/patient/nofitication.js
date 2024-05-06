const username = sessionStorage.getItem('userName')
const token = sessionStorage.getItem('jwt')
fetch('http://localhost:8080/notify/getnotify/'+username,{
    method:"GET",
    headers:{
        "Content-Type":"application/json",
        "Authorization":"Bearer "+token
    }
})
.then(response=>{
    return response.json()
})
.then(data=>{
    const parent= document.getElementById('Notification')
    var j=0;
    data.forEach(element => {
        j++
        var newNotification = document.createElement("div")
        newNotification.classList.add("notification-item")
        newNotification.innerHTML=`
        <h3>Thông Báo ${j}: ${element.title}</h3>
    <p>Nội dung: ${element.body}</p>
    <p class="notification-time">Thời gian: ${element.dateTime}</p>
        `
        parent.appendChild(newNotification)
    });
})