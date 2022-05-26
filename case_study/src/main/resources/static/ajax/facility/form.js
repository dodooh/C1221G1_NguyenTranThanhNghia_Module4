let $facilityTypeSelect = $('#facilityTypeSelect');
let $villaInputs = $('#villaInputs');
let $houseInputs = $('#houseInputs');
let $roomInputs = $('#roomInputs');

$(document).ready(function () {
  hideAll()
  $facilityTypeSelect.change(function () {
    if (this.value == 1) {
      $villaInputs.show();
      $villaInputs.find('input').prop('disabled', false);
      $houseInputs.hide();
      $houseInputs.find('input').prop('disabled', true);
      $roomInputs.hide();
      $roomInputs.find('input').prop('disabled', true);
    } else if (this.value == 2) {
      $villaInputs.hide();
      $villaInputs.find('input').prop('disabled', true);
      $houseInputs.show();
      $houseInputs.find('input').prop('disabled', false);
      $roomInputs.hide();
      $roomInputs.find('input').prop('disabled', true);
    } else if (this.value == 3) {
      $villaInputs.hide();
      $villaInputs.find('input').prop('disabled', true);
      $houseInputs.hide();
      $houseInputs.find('input').prop('disabled', true);
      $roomInputs.show();
      $roomInputs.find('input').prop('disabled', false);
    } else {
      hideAll()
    }
  })
})

function hideAll() {
  $villaInputs.hide();
  $villaInputs.find('input').prop('disabled', true);
  $houseInputs.hide();
  $houseInputs.find('input').prop('disabled', true);
  $roomInputs.hide();
  $roomInputs.find('input').prop('disabled', true);
}