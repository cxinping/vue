import request from '@/utils/request'

// 查询贷款使用列表
export function listTable(query) {
  return request({
    url: '/amount/loan/list',
    method: 'get',
    params: query
  })
}

// 查询贷款使用详细
export function getTable(id) {
  return request({
    url: '/amount/loan/' + id,
    method: 'get'
  })
}

// 新增贷款使用
export function addTable(data) {
  return request({
    url: '/amount/loan',
    method: 'post',
    data: data
  })
}

// 修改贷款使用
export function updateTable(data) {
  return request({
    url: '/amount/loan',
    method: 'put',
    data: data
  })
}

// 删除贷款使用
export function delTable(id) {
  return request({
    url: '/amount/loan/' + id,
    method: 'delete'
  })
}

// 导出贷款使用
export function exportTable(query) {
  return request({
    url: '/amount/loan/export',
    method: 'get',
    params: query
  })
}