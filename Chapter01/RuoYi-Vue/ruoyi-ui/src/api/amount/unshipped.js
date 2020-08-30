import request from '@/utils/request'

// 查询已购买未发货列表
export function listUnshipped(query) {
  return request({
    url: '/amount/unshipped/list',
    method: 'get',
    params: query
  })
}

// 查询已购买未发货详细
export function getUnshipped(id) {
  return request({
    url: '/amount/unshipped/' + id,
    method: 'get'
  })
}

// 新增已购买未发货
export function addUnshipped(data) {
  return request({
    url: '/amount/unshipped',
    method: 'post',
    data: data
  })
}

// 修改已购买未发货
export function updateUnshipped(data) {
  return request({
    url: '/amount/unshipped',
    method: 'put',
    data: data
  })
}

// 删除已购买未发货
export function delUnshipped(id) {
  return request({
    url: '/amount/unshipped/' + id,
    method: 'delete'
  })
}

// 导出已购买未发货
export function exportUnshipped(query) {
  return request({
    url: '/amount/unshipped/export',
    method: 'get',
    params: query
  })
}