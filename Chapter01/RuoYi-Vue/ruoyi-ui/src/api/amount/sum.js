import request from "@/utils/request";

// 查询库存汇总列表
export function listSum() {
  return request({
    url: "/amount/detail/list",
    method: "get"
  });
}

// 查询库存汇总详细
export function getSum(id) {
  return request({
    url: "/amount/sum/" + id,
    method: "get"
  });
}

// 新增库存汇总
export function addSum(data) {
  return request({
    url: "/amount/detail/add",
    method: "post",
    data: data
  });
}

// 修改库存汇总
export function updateSum(data) {
  return request({
    url: "/amount/detail/edit",
    method: "put",
    data: data
  });
}

// 删除库存汇总
export function delSum(id) {
  return request({
    url: "amount/detail/remove/" + id,
    method: "delete"
  });
}

// 导出库存汇总
export function exportSum(query) {
  return request({
    url: "/amount/detail/export",
    method: "get",
    params: query
  });
}
