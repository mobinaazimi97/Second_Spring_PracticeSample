function showEditPage(id) {
    document.location.replace("/products/" + id);
}

function deleteProduct(id) {
    fetch("/products/" + id, {
        method: "DELETE",
    });
    alert("Delete Product : " + id);
    document.location.replace("/products");
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