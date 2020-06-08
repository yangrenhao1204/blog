// tocbot
var headerEl = 'h1,h2,h3',  //headers
    content = '.post-content',//文章容器
    idArr = {};  //标题数组以确定是否增加索引id
//add #id
$(content).children(headerEl).each(function () {
    //去除空格以及多余标点
    var headerId = $(this).text().replace(/[\s|\~|`|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\_|\+|\=|\||\|\[|\]|\{|\}|\;|\:|\"|\'|\,|\<|\.|\>|\/|\?|\：|\，|\。]/g, '');

    headerId = headerId.toLowerCase();
    if (idArr[headerId]) {
        //id已经存在
        $(this).attr('id', headerId + '-' + idArr[headerId]);
        idArr[headerId]++;
    }
    else {
        //id未存在
        idArr[headerId] = 1;
        $(this).attr('id', headerId);
    }
});

tocbot.init({
    // Where to render the table of contents.
    tocSelector: '.toc',
    // Where to grab the headings to build the table of contents.
    contentSelector: content,
    // Which headings to grab inside of the contentSelector element.
    headingSelector: headerEl,
    // For headings inside relative or absolute positioned containers within content.
    hasInnerContainers: true,
    scrollSmooth: true,
});

//qrcode
// var articleLink = "https://yangrenhao.top";
function makeQRcode(articleLink) {
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width: 128,
        height: 128,
        colorDark: "#000000",
        colorLight: "#ffffff",
        correctLevel: QRCode.CorrectLevel.H,
        text: articleLink,
    });
}
// makeQRcode(articleLink)
// function makeCode (value) {
//     qrcode.makeCode(value);
// }
// makeCode("https://yangrenhao.top")

// $(function () {
//     $("[data-toggle='popover']").popover({
//         html : true,
//         content: "<div id='qrcode' style='width: 200px'></div>",
//         delay: {
//             // show: 500,
//             hide: 100,
//         }
//     }).on('click', function () {
//         makeCode("yangrenhao.top")
//     })
// })

//scrollTo
// $("#toTop-button").click(function () {
//     $(window).scrollTo(0, 500)
// })

//Waypoints
// var waypoint = new Waypoint({
//     element: document.getElementById('content-body'),
//     handler: function(direction) {
//         console.log('Scrolled to waypoint!')
//         if(direction == "down"){
//             //具体事件
//         } else {
//         }
//     }
// })