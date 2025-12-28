function registerPatient() {
  let name = document.getElementById("name").value;
  let age = document.getElementById("age").value;
  let mobile = document.getElementById("mobile").value;
  let msg = document.getElementById("message");

  if (name == "" || age == "" || mobile == "") {
    msg.style.color = "red";
    msg.innerText = "All fields are mandatory";
    return;
  }

  if (mobile.length != 10) {
    msg.style.color = "red";
    msg.innerText = "Invalid mobile number";
    return;
  }

  msg.style.color = "green";
  msg.innerText = "Patient Registered Successfully";
}
