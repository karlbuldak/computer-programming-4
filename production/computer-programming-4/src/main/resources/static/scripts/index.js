(() => {
    console.log("My ebook store works");
})();

const getProducts = () => {
    return fetch ("/api/products")
    .then(response => response.json();)
}

const createHtmlFromString = (HtmlAsString) => {const document.createElement('div')}

const createHtmlComponent = (product) => {
    const template = `
    <li>
    <h4>${product.name}</h4>
    <img />
    <span>${product.price}</span>
    <button
        class="product__add-to-cart"
        data-product-id="${product.id}"
     >
     Add to cart + </button>
     </li>`;
}

(()=> {
    const productsListEl = document.querySelector('#products-list');
    getProducts()
        .then(products => {
            products
            .map(product => createHtmlComponent(product))
            .forEach(el)})