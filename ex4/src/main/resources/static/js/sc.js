function selectAll() {
    const checkboxes = document.getElementsByName("checkBox1");
    for (let checkbox of checkboxes)
        checkbox.checked = this.checked;
    }
document.getElementById('checkBoxAll').onclick=selectAll() ;

