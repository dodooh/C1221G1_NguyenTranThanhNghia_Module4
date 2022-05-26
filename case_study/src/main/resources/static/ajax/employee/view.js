let $dCode = $('#dCode');
let $dName = $('#dName');
let $dDOB = $('#dDOB');
let $dNationalId = $('#dNationalId');
let $dAddress = $('#dAddress');
let $dPhone = $('#dPhone');
let $dMail = $('#dMail');
let $dSalary = $('#dSalary');
let $dPosition = $('#dPosition');
let $dEducation = $('#dEducation');
let $dDepartment = $('#dDepartment');
let $ajaxEmployee = $('#ajaxEmployee');
let $editAjaxBtn = $('#editAjaxBtn');
let $closeSpan = $('#closeSpan');
let $enableEditBtn = $('#enableEditBtn');

$(document).ready(function () {
  addOnClickToViewSpan();
  addOnClickToSubmitEditSpan();
  addOnClickToEnableEditSpan();
  $closeSpan.click(() => {
    $ajaxEmployee.hide();
  });

  $enableEditBtn.click(function (e) {
    e.preventDefault();
    $(this).hide();
    enabledAllTagToEdit();
    $editAjaxBtn.show();
  });
});

function collectInfo() {
  return {
    "id": $dCode.val(),
    "name": $dName.text(),
    "dayOfBirth": $dDOB.val(),
    "nationalId": $dNationalId.val(),
    "address": $dAddress.val(),
    "phoneNumber": $dPhone.val(),
    "email": $dMail.val(),
    "position": {
      "id": $dPosition.val(),
    },
    "educationDegree": {
      "id": $dEducation.val(),
    },
    "department": {
      "id": $dDepartment.val(),
    },
    "salary": $dSalary.val()
  };
}

function disabledAllTagToView() {
  $ajaxEmployee.find('input').prop('disabled', true);
  $ajaxEmployee.find('select').prop('disabled', true);
}

function enabledAllTagToEdit() {
  $ajaxEmployee.find('input').prop('disabled', false);
  $ajaxEmployee.find('select').prop('disabled', false);
}

function addOnClickToViewSpan() {
  $('.viewSpan').click(function () {
    let id = $(this).data('employee-id');
    $.ajax({
      type: "GET",
      url: "/api/employee/" + id,
      success: function (data) {
        resHandler(data);
        disabledAllTagToView();
        $ajaxEmployee.show();
        $enableEditBtn.show();
        $editAjaxBtn.hide();
      },
      error: function (error) {
        alert("error");
      }
    });
  });
}

function addOnClickToEnableEditSpan() {
  $('.editSpan').click(function () {
    let id = $(this).data('employee-id');
    $.ajax({
      type: "GET",
      url: "/api/employee/" + id,
      success: function (data) {
        resHandler(data);
        enabledAllTagToEdit();
        $ajaxEmployee.show();
        $enableEditBtn.hide();
        $editAjaxBtn.show();
      },
      error: function (error) {
        alert("error");
      }
    });
  });
}

function resHandler(data) {
  console.log(data);
  if (data.message != null) {
    $('#messageResponse').text(data.message);
  }
  let unformattedDOB = data.employee.dayOfBirth;
  let formattedDOB = unformattedDOB.split('-')[2] + '/' + unformattedDOB.split(
      '-')[1] + '/' + unformattedDOB.split('-')[0];
  /*Fill data to form*/
  $dName.text(data.employee.name);
  $dCode.val(data.employee.id);
  $dDOB.val(formattedDOB);
  $dNationalId.val(data.employee.nationalId);
  $dAddress.val(data.employee.address);
  $dPhone.val(data.employee.phoneNumber);
  $dMail.val(data.employee.email);
  $dSalary.val(data.employee.salary);
  $editAjaxBtn.attr('href', data.employee.id);
  $dPosition.html('');
  $.each(data.positions, function () {
    $dPosition.append($("<option />").val(this.id).text(this.positionName));
  });

  $dDepartment.html('');
  $.each(data.departments, function () {
    $dDepartment.append(
        $("<option />").val(this.id).text(this.departmentName));
  });

  $dEducation.html('');
  $.each(data.educationDegrees, function () {
    $dEducation.append(
        $("<option />").val(this.id).text(this.educationDegreeName));
  });
  /*Match data that selected*/
  $('#dPosition option[value=' + data.employee.position.id + ']').prop(
      "selected", true);
  $('#dEducation option[value=' + data.employee.educationDegree.id + ']').prop(
      "selected", true);
  $('#dDepartment option[value=' + data.employee.department.id + ']').prop(
      "selected", true);
}

function addOnClickToSubmitEditSpan() {
  $editAjaxBtn.click(function (e) {
    e.preventDefault();
    let employeeDTO = collectInfo();
    console.log(employeeDTO);
    $.ajax({
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      type: "PATCH",
      data: JSON.stringify(employeeDTO),
      url: "/api/employee",
      success: function (data) {
        resHandler(data);
        disabledAllTagToView();
        $editAjaxBtn.hide();
        $enableEditBtn.show();
      },
    });
  });
}

