/**
 * Created by makewei on 2019/5/13.
 */

var fileTree = {
    name: "项目1",
    sonFile:[
        {
            name: "文件夹1",
            sonFile:[]
        }
    ]
}


localStorage.setItem("fileTree",JSON.stringify(fileTree))

var fileName
var fatherName
var name

function newFile(){
    console.log("===>newFile")
    if(!fileName){
        console.error("not found fileName")
        return
    }
    if(!fatherName){
        console.error("not found fatherName")
        return
    }
    addNewFile(fileTree)
}

function addNewFile(node) {
    if(node.name && node.name === fatherName){
        node.sonFile.push({
            name: fileName,
            sonFile: []
        })
        localStorage.setItem("fileTree",JSON.stringify(fileTree))
        fileName = ""
        fatherName = ""
        window.location.reload();
        console.log('success',fileTree)
    } else {
        if (node.sonFile.length){
            for(let i = 0;i<node.sonFile.length;i++){
                addNewFile(node.sonFile[i])
                //window.location.reload();
            }
        }
    }


}

function changeFatherName(name) {
    fatherName = name
    console.log('fatherName',fatherName)
}

function changeFileName(name){
    fileName = name
    console.log('fileName',fileName)
}
//
// export default {
//     file2
// }

function uploadCodeFile() {
    var pid = getQueryString("pid");

    $.ajax({
        url: '/post/uploadCodeFile?pid=' + pid,
        type: 'POST',
        cache: false,
        data: new FormData($('#uploadForm')[0]),
        processData: false,
        contentType: false,
        success: function(msg){
            if(msg == "fail"){
                alert("提交失败，请重试");
                return false;
            }else if(msg == "success") {
                alert("提交成功");
                var data = document.getElementById('upload_file').value;
                var dot = data.lastIndexOf("\\")
                name = data.substr(dot+1)
                window.location.reload();
            }
        },
        error: function (exc) {
            alert("发生错误，请重试");
            console.log(exc);
        }
    });

    return false;
}

function goToCodeRelation(pid, cid) {
    window.location.href = '/post/codeRelation?pid=' + pid + '&cid=' + cid;
}

/**
 * 添加代码需求关联
 * @param pid
 * @param rid
 */

function goToEditRelation(pid, cid, rid, state) {
    window.location.href = '/post/editCodeRelation?pid=' + pid + '&cid=' + cid + '&rid=' + rid+ '&state=' + state;
    // var data = {pid:pid, cid:cid, rid:rid, state:state};
    // $.ajax({
    //     url:'/post/editCodeRelation',
    //     data: data,
    //     type: 'GET',
    //     success: function(msg){
    //         if(msg == "fail"){
    //             alert("编辑失败，请重试");
    //             return false;
    //         }else if(msg == "success") {
    //             alert("编辑成功");
    //             window.location.reload();
    //         }
    //     },
    //     error: function (exc) {
    //         alert("发生错误，请重试");
    //         window.location.reload();
    //         console.log(exc);
    //     }
    // });
    // return false;
}

function editUMLRelation(pid, cid, umlid, ustate) {
    window.location.href = '/post/editUMLRelation?pid=' + pid + '&cid=' + cid + '&umlid=' + umlid+ '&ustate=' + ustate;
}


function deleteRelation(pid, rid) {
    //window.location.href = '/post/deleteRelation?pid=' + pid + '&rid=' + rid;
    var data = {pid:pid, rid:rid};
    $.ajax({
        url:'/post/deleteRelation',
        data: data,
        type: 'GET',
        success: function(msg){
            if(msg == "fail"){
                alert("取消关联失败，请重试");
                return false;
            }else if(msg == "success") {
                alert("取消关联成功");
                window.location.reload();
            }
        },
        error: function (exc) {
            alert("取消关联成功");
            window.location.reload();
            console.log(exc);
        }
    });
}

function codeManagement(pid) {
    window.location.href = '/post/codeManagement?pid=' + pid;
}

function codeManagement1(pid) {
    window.location.href = '/post/codeManagement1?pid=' + pid;
}

function codeManagement1_1(pid) {
    window.location.href = '/post/codeManagement1_1?pid=' + pid;
}

function codeManagement1_2(pid) {
    window.location.href = '/post/codeManagement1_2?pid=' + pid;
}

function codeManagement2(pid) {
    window.location.href = '/post/codeManagement2?pid=' + pid;
}

function codeManagement3(pid) {
    window.location.href = '/post/codeManagement3?pid=' + pid;
}