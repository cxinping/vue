import request from "@/utils/request";

// 查询在途物资列表
export function listTransit(query) {
  return request({
    url: "/amount/transit/detail/list",
    method: "get",
    params: query
  });
}

// 查询在途物资详细
export function getTransit(id) {
  return request({
    url: "/amount/transit/detail/" + id,
    method: "get"
  });
}

// 新增在途物资
export function addTransit(data) {
  return request({
    url: "/amount/transit/detail",
    method: "post",
    data: data
  });
}

// 修改在途物资
export function updateTransit(data) {
  return request({
    url: "/amount/transit/detail/edit",
    method: "put",
    data: data
  });
}

// 删除在途物资
export function delTransit(id) {
  return request({
    url: "/amount/transit/detail/" + id,
    method: "delete"
  });
}

// 导出在途物资
export function exportTransit(query) {
  return request({
    url: "/amount/transit/export",
    method: "get",
    params: query
  });
}
