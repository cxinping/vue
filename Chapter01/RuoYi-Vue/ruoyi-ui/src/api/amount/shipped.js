import request from '@/utils/request'

// 查询已下单未发货列表
export function listShipped(query) {
  return request({
    url: '/amount/shipped/list',
    method: 'get',
    params: query
  })
}

// 查询已下单未发货详细
export function getShipped(id) {
  return request({
    url: '/amount/shipped/' + id,
    method: 'get'
  })
}

// 新增已下单未发货
export function addShipped(data) {
  return request({
    url: '/amount/shipped',
    method: 'post',
    data: data
  })
}

// 修改已下单未发货
export function updateShipped(data) {
  return request({
    url: '/amount/shipped',
    method: 'put',
    data: data
  })
}

// 删除已下单未发货
export function delShipped(id) {
  return request({
    url: '/amount/shipped/' + id,
    method: 'delete'
  })
}

// 导出已下单未发货
export function exportShipped(query) {
  return request({
    url: '/amount/shipped/export',
    method: 'get',
    params: query
  })
}