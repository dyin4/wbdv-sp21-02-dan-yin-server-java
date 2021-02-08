var $tableRows
var $createBtn
var courseService = new CourseServiceClient()
var $titleFld
var $sectionFld
var $seatsFld
var $semesterFld
var $updateBtn



var courses = [
  {title: "CS5400", section: "02", seats: 23, semester: "Spring"},
  {title: "CS5200", section: "02", seats: 34, semester: "Spring"},
  {title: "CS3460", section: "02", seats: 57, semester: "Spring"},
  {title: "CS5300", section: "02", seats: 67, semester: "Spring"},
]

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

function createCourse() {
    var newCourse = {
      title: $titleFld.val(),
      section: $sectionFld.val(),
      seats: $seatsFld.val(),
      semester: "SPRING"
    }

    courseService.createCourse(newCourse)
      .then(function (actualCourse) {
        courses.push(actualCourse)
        renderCourses(courses)
      })

}

var selectedCourse = null

function selectCourse(event) {
  var id = $(event.target).attr("id")
  selectedCourse = courses.find(course => course._id === id)
  $titleFld.val(selectedCourse.title)
  $seatsFld.val(selectedCourse.seats)
  $sectionFld.val(selectedCourse.section)
  $semesterFld.val(selectedCourse.semester)
}

function updateCourse() {
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
function renderCourses() {

  $tableRows.empty();
  for (var i = 0; i < courses.length; i++) {
    var course = courses[i]
    $tableRows.prepend(`   <tr>
                <td>${course.title}</td>
                <td>${course.section}</td>
                <td>${course.seats}</td>
                <td>${course.semester}</td>
                <td>
                  <button id="${i}" class="dy-delete-btn">Delete</button>
                  <button id="${course._id}" class="dy-select-btn">Select</button>
                </td>
              </tr>`)

  }

  $(".dy-delete-btn").click(deleteCourse)
  $(".dy-select-btn").click(selectCourse)
}

function main() {
  $tableRows = jQuery("#table-rows")
  $createBtn = $(".dy-create-btn")
  $createBtn.click(createCourse)

  $updateBtn = $(".dy-update-btn")
  $updateBtn.click(updateCourse)

  $titleFld = $(".dy-title-fld")
  $sectionFld = $(".dy-section-fld")
  $seatsFld = $(".dy-seats-fld")
  $semesterFld = $(".dy-semester-fld")

  courseService.findAllCourses().then(function (actualCourses) {
    courses = actualCourses
    renderCourses(courses)
  })

}

$(main)