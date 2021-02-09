var $usernameFld, $passwordFld;
var $firstNameFld, $lastNameFld, $roleFld;
var $removeBtn, $editBtn, $createBtn;
var $userRowTemplate, $tbody;
var userService = new AdminUserServiceClient();

var selectedUser = null

var users = [
  {username: "ada", password: "02", firstname: "Love", lastname: "DD",
    role: "Admin"}
]

function createUser() {
  var newUser = {
    username: $usernameFld.val(),
    password: $passwordFld.val(),
    firstname: $firstNameFld.val(),
    lastname: $lastNameFld.val(),
    role: $roleFld.val()
  }

  userService.createUser(newUser)
  .then(function (actualUser) {
    users.push(actualUser)
    renderCourses(users)
  })
}
// function deleteUser() { … }
function updateUser() {
  selectedCourse.title = $titleFld.val()
  selectedCourse.semester = $semesterFld.val()
  selectedCourse.seats = $seatsFld.val()
  courseService.updateCourse(selectedCourse._id, selectedCourse)
  .then(status => {
    var index = courses.findIndex(course => course._id === selectedCourse._id)
    courses[index] = selectedCourse
    renderCourses(courses)
  })
}
// function renderUsers(users) { … }

function deleteCourse(event) {
  var button = $(event.target)
  var index = button.attr("id")
  var id = courses[index]._id
  courseService.deleteCourse(id)
  .then(function (status) {
    courses.splice(index,1);
    renderCourses(courses)
  })
}


function selectUser(event) {
  console.log(event.target)
  // var id = $(event.target).attr("id")
  console.log(id)
  // selectedUser = users.find(user => user._id === id)
  // $titleFld.val(selectedCourse.title)
  // $seatsFld.val(selectedCourse.seats)
  // $sectionFld.val(selectedCourse.section)
  // $semesterFld.val(selectedCourse.semester)
}

function renderUsers() {

  $tbody.empty();
  for (var i = 0; i < users.length; i++) {
    var user = users[i]
    $tbody.append(`   <tr class="wbdv-template wbdv-user wbdv-hidden">
                            <td class="wbdv-username">${user.username}</td>
                            <td>&nbsp;</td>
                            <td class="wbdv-first-name">${user.firstname}</td>
                            <td class="wbdv-last-name">${user.lastname}</td>
                            <td class="wbdv-role">${user.role}</td>
                            <td class="wbdv-actions">
                                <span class="float-right">
                                  <i id="${i}" class="fa-2x fa fa-times wbdv-remove"></i>
                                  <i id="${i}" class="fa-2x fa fa-pencil wbdv-edit"></i>
                                </span>
                            </td>
                          </tr>`)

  }

  // $(".wbdv-remove").click()
  $(".wbdv-edit").click(selectUser)
}

function main() {
  $tbody = jQuery(".wbdv-tbody")
  $createBtn = $(".wbdv-create")
  $editBtn = $(".wbdv-update")


  $createBtn.click(createUser)
  $editBtn.click(updateUser)

  $usernameFld = $("#usernameFld")
  $firstNameFld = $("#firstNameFld")
  $passwordFld = $("#passwordFld")
  $lastNameFld = $("#lastNameFld")
  $roleFld = $("#roleFld")

  userService.findAllUsers().then(function (actualUsers) {
    users = actualUsers
    renderUsers(users)
  })

}

$(main)