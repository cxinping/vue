import request from '@/utils/request'

// 查询可用资金列表
export function listFunds(query) {
  return request({
    url: '/amount/funds/list',
    method: 'get',
    params: query
  })
}

// 查询可用资金详细
export function getFunds(id) {
  return request({
    url: '/amount/funds/' + id,
    method: 'get'
  })
}

// 新增可用资金
export function addFunds(data) {
  return request({
    url: '/amount/funds',
    method: 'post',
    data: data
  })
}

// 修改可用资金
export function updateFunds(data) {
  return request({
    url: '/amount/funds',
    method: 'put',
    data: data
  })
}

// 删除可用资金
export function delFunds(id) {
  return request({
    url: '/amount/funds/' + id,
    method: 'delete'
  })
}

// 导出可用资金
export function exportFunds(query) {
  return request({
    url: '/amount/funds/export',
    method: 'get',
    params: query
  })
}