function showEditPage(id) {
    document.location.replace("/orders/" + id);
}

function deleteOrder(id) {
    fetch("/orders/" + id, {
        method: "DELETE",
    });
    alert("Delete Order : " + id);
    document.location.replace("/orders");
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