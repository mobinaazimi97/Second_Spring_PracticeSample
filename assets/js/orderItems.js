function showEditPage(id) {
    document.location.replace("/orderItems/" + id);
}

function deleteItem(id) {
    fetch("/orderItems/" + id,{
        method: "DELETE",
    });
    alert("Delete OrderItem : " + id);
    document.location.replace("/orderItems");
}
function getItemsByOrderId(id) {
    fetch("/orderItems/" + id,{
        method: "GET",
    });
    alert("Found OrderItem By OrderId : " + id);
    document.location.replace("/orderItems");
}

// function editProduct() {
//     const id = document.getElementById('id').value;
//     const name = document.getElementById('name').value;
//     const price = document.getElementById('price').value;
//
//     fetch('/products?id='+id + '&name=' + name + '&price=' + price, {
//         method: 'PUT'
//     });
//     alert('Updated successfully');
//
//     document.location.replace("/products");
// }